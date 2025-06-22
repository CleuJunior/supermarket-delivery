package br.com.smd.products.supermarket_delivery_products.dto.request;

import java.util.List;

public record SearchProductQueryRequest(
        String name,
        List<String> productsId,
        String brand,
        Boolean inStock,
        String sort,
        String order,
        int page,
        int size
) {
}
