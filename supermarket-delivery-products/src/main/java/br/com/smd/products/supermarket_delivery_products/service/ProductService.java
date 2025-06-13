package br.com.smd.products.supermarket_delivery_products.service;

import br.com.smd.products.supermarket_delivery_products.domain.Product;
import br.com.smd.products.supermarket_delivery_products.dto.request.ProductRequest;
import br.com.smd.products.supermarket_delivery_products.dto.response.ProductResponse;
import br.com.smd.products.supermarket_delivery_products.exception.NotFoundException;
import br.com.smd.products.supermarket_delivery_products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductResponse findById(String productId) {
        return repository.findById(productId)
                .map(ProductResponse::new)
                .orElseThrow(() -> {
                    log.warn("Product id: [{}] not found", productId);
                    return new NotFoundException("product.id.not.found", productId);
                });
    }

    public List<ProductResponse> getList() {
        return repository.productsNotDeleted()
                .stream()
                .filter(Objects::nonNull)
                .map(ProductResponse::new)
                .toList();
    }

    public ProductResponse saveProduct(ProductRequest request) {
        Product entity = new Product(request);
        repository.save(entity);

        return new ProductResponse(entity);
    }
}
