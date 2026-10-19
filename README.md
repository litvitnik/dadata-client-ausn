# dadata-client

Dadata Suggestions API client for Spring (Java)

## Overview

Dadata API client based on non-blocking HTTP client of Spring WebClient. Supports all methods of Suggestion API

## [Release notes](ReleaseNotes.md)

## Add a dependency

Gradle:

	dependencies {
	        implementation 'ru.wb.fintech.sellerloans.dadata:dadata-client:4.0.1'
	}

Maven:

	<dependency>
	    <groupId>ru.wb.fintech.sellerloans.dadata</groupId>
	    <artifactId>dadata-client</artifactId>
	    <version>4.0.1</version>
	</dependency>

Артефакт публикуется в nexus `seller-loans-maven2-release-public`. Версии помимо тегов содержат суффикс с коротким хешем коммита (например `4.0.1.615f6975`); версия без суффикса публикуется с защищенного тега в prod.

## Configuration

Dadata client provides `DadataClientAutoConfiguration` which configures `DadataClient` bean for you.

### Primary settings

It's required to add property `dadata.client.token` with your Dadata API Token.

You may add property `dadata.client.timeout` to configure dadata client request timeout, defaults to 5 seconds.

Via `dadata.client.baseUrl` you can change Dadata base url, defaults to https://suggestions.dadata.ru/suggestions/api/4_1/rs

`dadata.client.maxInMemorySize` defines max buffer size for response, defaults to 512K. You can change it if you have memory issues.

### Proxy support and SSL verification

`dadata.client.proxy.type` - valid values are: HTTP, SOCKS4, SOCKS5, defaults to HTTP

`dadata.client.proxy.server` - proxy hostname or ip address

`dadata.client.proxy.port` - proxy port, positive number

If you have configured above options you can use authentication via username/password pair just setting system properties for them.

-   for HTTP proxy you should use `http.proxyUser` and `http.proxyPassword` respectively.
-   for SOCKS proxy you should use `java.net.socks.username` and `java.net.socks.password` respectively.

There is no authorization at proxy if no username defined in system environment.

`dadata.client.verifySsl` - enable/disable server SSL-certificate verification at client-side, defaults to true

## Usage

Autowire `DadataClient` in your beans and call api methods, for example:

```
@Service
public class SomeService {
    
    @Autowired
    private DadataClient client;
    
    public Flux<Suggestion<Address>> getSuggestionsForAddress(String query) {
        return client.suggestAddress(AddressRequestBuilder.create(query).build());
    }
}
```

Request builders allow filter and rank suggestions. More examples are available in the `test` module 
