import org.springframework.boot.gradle.plugin.SpringBootPlugin


plugins {
    id("java-library")
    id("maven-publish")
    id("com.dorongold.task-tree") version "2.1.1"

    id("io.spring.dependency-management") version "1.1.5"
    id("org.springframework.boot") version "3.3.1" apply false
}


group = "ru.wb.fintech.sellerloans.dadata"

repositories {
    maven(url = uri("https://nexus-proxy.wb.ru/repository/maven-proxy-gradle-plugins/"))
    maven(url = uri("https://nexus-hosted.wb.ru/repository/seller-loans-maven2-release-public/"))
    maven(url = uri("https://nexus.ipa.paywb.lan/repository/seller-loans-maven2-release-public/"))
    maven(url = uri("https://nexus.apa.paywb.lan/repository/seller-loans-maven2-release-public/"))
}


dependencyManagement {
    imports {
        mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
}


java {
    withSourcesJar()
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}


configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


dependencies {
    api("org.springframework.boot:spring-boot-autoconfigure")
    api("org.springframework:spring-webflux")
    api("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.springframework.boot:spring-boot")
    implementation("io.projectreactor.netty:reactor-netty")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.slf4j:slf4j-api")
    implementation("jakarta.validation:jakarta.validation-api")
    implementation("org.hibernate.validator:hibernate-validator")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


val ciCommitShortShaEnv = "CI_COMMIT_SHORT_SHA"
val ciCommitTagProtectedEnv = "CI_COMMIT_REF_PROTECTED"
val deployEnvironmentEnv = "CI_TMPL_ENVIRONMENT_NAME"

publishing {
    publications {
        create<MavenPublication>("dadata-client") {
            artifactId = "dadata-client"
            version += computePublishPackageNameSuffix()
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }

    repositories {
        maven {
            name = "fintech"
            url = uri(System.getenv("FINTECH_MAVEN_URL").orEmpty())
            credentials {
                username = System.getenv("FINTECH_MAVEN_LOGIN").orEmpty()
                password = System.getenv("FINTECH_MAVEN_PASSWORD").orEmpty()
            }
        }
    }
}


fun computePublishPackageNameSuffix(): String {
    val deployEnvironment = System.getenv(deployEnvironmentEnv).orEmpty()
    val commitHash = System.getenv(ciCommitShortShaEnv).orEmpty()
    val branchProtected = System.getenv(ciCommitTagProtectedEnv).orEmpty().toBooleanStrictOrNull()
    if (deployEnvironment == "prod" && branchProtected == true) {
        return ""
    }

    if (commitHash == "") {
        return ".local"
    }

    return ".$commitHash"
}
