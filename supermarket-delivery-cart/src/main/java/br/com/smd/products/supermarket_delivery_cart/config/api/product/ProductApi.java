package br.com.smd.products.supermarket_delivery_cart.config.api.product;

import br.com.smd.products.supermarket_delivery_cart.domain.Product;
import br.com.smd.products.supermarket_delivery_cart.dto.request.ProductSearchQueryRequest;
import feign.Headers;
import feign.RequestLine;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductApi {

    @RequestLine("GET /v1/products")
    @Headers({"Accept: application/json"})
    List<Product> listProducts();

    @RequestLine("POST /v1/products/search")
    @Headers({"Accept: application/json"})
    List<Product> searchProducts(ProductSearchQueryRequest request);

    @RequestLine("GET /v1/products/{productId}")
    @Headers({"Accept: application/json"})
    Product getProductById(@Param("productId") String productId);
}
