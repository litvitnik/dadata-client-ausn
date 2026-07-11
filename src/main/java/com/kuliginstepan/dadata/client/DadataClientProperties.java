package com.kuliginstepan.dadata.client;

import jakarta.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.unit.DataSize;
import org.springframework.validation.annotation.Validated;
import reactor.netty.transport.ProxyProvider;

@Data
@Validated
@ConfigurationProperties(prefix = "dadata.client")
public class DadataClientProperties {

    @Data
    @NoArgsConstructor
    public static class ProxyProperties {
        /**
         * Proxy server type, defaults to HTTP
         */
        @NotNull
        private ProxyProvider.Proxy type = ProxyProvider.Proxy.HTTP;

        /**
         * Proxy server address
         */
        @NotNull
        private String server;

        /**
         * Proxy server port
         */
        @NotNull
        private Integer port;
    }

    /**
     * Dadata base url
     */
    private String baseUrl = "https://suggestions.dadata.ru/suggestions/api/4_1/rs";

    /**
     * Dadata API token
     */
    private String token;

    /**
     * Request timeout. Default - 5 seconds
     */
    private Duration timeout = Duration.of(5, ChronoUnit.SECONDS);

    /**
     * Maximum byte buffer size. Default - 512 Kb
     */
    private DataSize maxInMemorySize = DataSize.ofKilobytes(512L);

    /**
     * Proxy properties
     */
    private ProxyProperties proxy;

    /**
     * SSL verification option
     */
    private boolean verifySsl = true;

    /**
     * Максимальное количество соединений в пуле.
     * Рекомендуется устанавливать не более 50, чтобы не превысить 60 новых соединений в минуту.
     * По умолчанию 30.
     */
    private int maxConnections = 30;

    /**
     * Время ожидания свободного соединения из пула, если все заняты.
     * По умолчанию 30 секунд.
     */
    private Duration pendingAcquireTimeout = Duration.ofSeconds(30);

    /**
     * Максимальное время простоя соединения в пуле (после этого оно закрывается).
     * По умолчанию 60 секунд.
     */
    private Duration maxIdleTime = Duration.ofSeconds(60);

    /**
     * Максимальное время жизни соединения (с момента создания).
     * По умолчанию 60 секунд.
     */
    private Duration maxLifeTime = Duration.ofSeconds(60);

    /**
     * Интервал фоновой очистки пула от простаивающих соединений.
     * По умолчанию 30 секунд.
     */
    private Duration evictInBackground = Duration.ofSeconds(30);
}
