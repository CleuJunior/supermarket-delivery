package br.com.smd.products.supermarket_delivery_products.dto.response;

import br.com.smd.products.supermarket_delivery_products.domain.Product;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public record ProductResponse(
        String id,
        String name,
        String brand,
        BigDecimal price,
        ZonedDateTime dueDate,
        int quantity,
        boolean inStock,
        boolean deleted,
        ZonedDateTime creationDate,
        ZonedDateTime lastModifiedDate
) {

    public ProductResponse(Product entity) {
        this(
                entity.getId(),
                entity.getName(),
                entity.getBrand(),
                entity.getPrice(),
                entity.getDueDate(),
                entity.getQuantity(),
                entity.isInStock(),
                entity.isDeleted(),
                entity.getCreationDate(),
                entity.getLastModifiedDate()
        );
    }
}

