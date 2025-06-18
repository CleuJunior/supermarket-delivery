package br.com.smd.products.supermarket_delivery_products.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ClientUpdateAddressRequest(
        String street,
        int number,
        @JsonProperty("zip_code")
        String zipCode,
        String city,
        String state,
        String neighborhood,
        String complement
) {
}

