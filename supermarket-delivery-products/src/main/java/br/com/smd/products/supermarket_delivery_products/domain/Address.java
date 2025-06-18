package br.com.smd.products.supermarket_delivery_products.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@Builder
public class Address {
    private String street;
    private int number;
    @Field("zip-code")
    private String zipCode;
    private String city;
    private String state;
    private String neighborhood;
    private String complement;
}
