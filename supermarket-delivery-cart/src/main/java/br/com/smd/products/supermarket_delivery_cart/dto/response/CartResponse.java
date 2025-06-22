package br.com.smd.products.supermarket_delivery_cart.dto.response;

import br.com.smd.products.supermarket_delivery_cart.domain.Cart;
import br.com.smd.products.supermarket_delivery_cart.domain.Client;
import br.com.smd.products.supermarket_delivery_cart.domain.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

public record CartResponse(
        String id,
        Client client,
        List<Product> productList,
        @JsonProperty("total_price")
        BigDecimal totalPrice,
        boolean delivered,
        boolean deleted,
        @JsonProperty("creation_date")
        ZonedDateTime creationDate,
        @JsonProperty("last_modified_date")
        ZonedDateTime lastModifiedDate
) {
    public CartResponse(Cart entity) {
        this(
                entity.getId(),
                entity.getClient(),
                entity.getProductList(),
                entity.getTotalPrice(),
                entity.isDelivered(),
                entity.isDeleted(),
                entity.getCreationDate(),
                entity.getLastModifiedDate()
        );
    }
}
