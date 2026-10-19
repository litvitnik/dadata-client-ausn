rootProject.name = "dadata-client"


pluginManagement {
    repositories {
        maven(url = uri("https://nexus-proxy.wb.ru/repository/maven-proxy-gradle-plugins"))
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
