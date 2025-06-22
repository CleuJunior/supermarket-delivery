package br.com.smd.products.supermarket_delivery_cart.config.api.client;

import org.springframework.data.mongodb.core.mapping.Field;

public record AddressDto(String street, int number, @Field("zip-code") String zipCode, String city, String state,
                         String neighborhood, String complement) {
}
