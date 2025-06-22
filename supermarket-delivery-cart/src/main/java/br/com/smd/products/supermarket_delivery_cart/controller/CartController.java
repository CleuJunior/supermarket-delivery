package br.com.smd.products.supermarket_delivery_cart.controller;

import br.com.smd.products.supermarket_delivery_cart.dto.request.CartRequest;
import br.com.smd.products.supermarket_delivery_cart.domain.Client;
import br.com.smd.products.supermarket_delivery_cart.dto.response.CartResponse;
import br.com.smd.products.supermarket_delivery_cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;

    @GetMapping("/{cartId}")
    public ResponseEntity<CartResponse> getCartById(@PathVariable("cartId") String cartId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(cartId));
    }

    @GetMapping
    public ResponseEntity<List<CartResponse>> getListCarts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getListCarts());
    }

    @PostMapping
    public ResponseEntity<CartResponse> saveCart(@RequestBody CartRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.saveCart(request));
    }
}
