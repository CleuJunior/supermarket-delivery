package br.com.smd.products.supermarket_delivery_cart.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public record Client(
        String id,
        String name,
        String cpf,
        String email,
        @Field("phone_number")
        String phoneNumber,
        Address address,
        boolean deleted
) {
}

