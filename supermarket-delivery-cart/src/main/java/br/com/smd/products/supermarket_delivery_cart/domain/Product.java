package br.com.smd.products.supermarket_delivery_cart.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public record Product(String id, String name, String brand, BigDecimal price, ZonedDateTime dueDate, int quantity,
                      boolean inStock, boolean deleted) {
}

