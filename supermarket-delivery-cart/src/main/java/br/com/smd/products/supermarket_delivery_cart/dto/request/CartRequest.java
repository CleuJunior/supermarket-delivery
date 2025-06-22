package br.com.smd.products.supermarket_delivery_cart.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CartRequest(String clientId, List<String> productsIds) {
}

