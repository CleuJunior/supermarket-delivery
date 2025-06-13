package br.com.smd.products.supermarket_delivery_products.dto.request;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public record ProductRequest(
        String name,
        String brand,
        BigDecimal price,
        ZonedDateTime dueDate,
        int quantity,
        boolean inStock
) {

}

