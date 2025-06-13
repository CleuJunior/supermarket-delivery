package br.com.smd.products.supermarket_delivery_products.controller;


import br.com.smd.products.supermarket_delivery_products.dto.request.ProductRequest;
import br.com.smd.products.supermarket_delivery_products.dto.response.ProductResponse;
import br.com.smd.products.supermarket_delivery_products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ItemController {

    private final ProductService service;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> search(@PathVariable("productId") String productId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getListProduct() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getList());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveProduct(request));
    }
}
