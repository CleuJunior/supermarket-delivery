package br.com.smd.products.supermarket_delivery_cart.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class ProductSearchQueryRequest {
    List<String> productsIds;
}
