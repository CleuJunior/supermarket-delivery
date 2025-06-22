package br.com.smd.products.supermarket_delivery_cart.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public record Address(
        String street,
        int number,
        @Field("zip-code")
        String zipCode,
        String city,
        String state,
        String neighborhood,
        String complement
) {
}
