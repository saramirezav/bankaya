package com.mx.bankaya.challenge.configuration;

import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Help us to customize beans: Decoder, Encoder, Logger, Contract, Feign-Builder, Client
 * @author Sarahy Ramirez
 */
@Configuration
public class MyClientConfiguration {

    /**
     * Configure Feign to use OkHttpClient instead of the default one to support HTTP/2
     * @return OkHttpClient
     */
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }
}
