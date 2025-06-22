package br.com.smd.products.supermarket_delivery_cart.config.api.product;

import br.com.smd.products.supermarket_delivery_cart.config.ApiErrorDecoder;
import br.com.smd.products.supermarket_delivery_cart.config.LocaleInterceptor;
import br.com.smd.products.supermarket_delivery_cart.config.RequisitionLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Client;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static feign.Logger.Level.FULL;

@Configuration
@RequiredArgsConstructor
public class ProductApiConfiguration {

    @Value("${api.supermarket.url}")
    private String url;

    private final Client client;
    private final JacksonEncoder encoder;
    private final JacksonDecoder decoder;
    private final ObjectMapper mapper;
    private final LocaleInterceptor localeInterceptor;
    private final RequisitionLogger requisitionLogger;

    @Bean
    public ProductApi productApi() {
        return Feign.builder()
                .client(client)
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(new ApiErrorDecoder(mapper, "Product Supermarket API"))
                .requestInterceptor(localeInterceptor)
                .logger(requisitionLogger)
                .logLevel(FULL)
                .target(ProductApi.class, url);
    }
}
