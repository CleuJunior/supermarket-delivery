package br.com.smd.products.supermarket_delivery_cart.config;

import feign.Client;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HttpClientConfiguration {
    @Bean
    public Client httpClient() {
        return new OkHttpClient();
    }

    @Bean
    public JacksonEncoder jsonEncoder() {
        return new JacksonEncoder();
    }

    @Bean
    public JacksonDecoder jsonDecoder() {
        return new JacksonDecoder();
    }
}
