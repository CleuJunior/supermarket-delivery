package br.com.smd.products.supermarket_delivery_products.dto.request;

public record SearchProductQueryRequest(
        String name,
        String brand,
        Boolean inStock,
        String sort,
        String order,
        int page,
        int size
) {
}
