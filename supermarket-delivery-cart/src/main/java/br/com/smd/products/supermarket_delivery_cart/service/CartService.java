package br.com.smd.products.supermarket_delivery_cart.service;

import br.com.smd.products.supermarket_delivery_cart.config.api.client.ClientApi;
import br.com.smd.products.supermarket_delivery_cart.config.api.product.ProductApi;
import br.com.smd.products.supermarket_delivery_cart.domain.Cart;
import br.com.smd.products.supermarket_delivery_cart.domain.Client;
import br.com.smd.products.supermarket_delivery_cart.domain.Product;
import br.com.smd.products.supermarket_delivery_cart.dto.request.CartRequest;
import br.com.smd.products.supermarket_delivery_cart.dto.request.ProductSearchQueryRequest;
import br.com.smd.products.supermarket_delivery_cart.dto.response.CartResponse;
import br.com.smd.products.supermarket_delivery_cart.exception.NotFoundException;
import br.com.smd.products.supermarket_delivery_cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class CartService {

    private final CartRepository repository;
    private final ClientApi clientService;
    private final ProductApi productService;

    public CartResponse findById(String cartId) {
        return repository.findById(cartId)
                .map(CartResponse::new)
                .orElseThrow(() -> {
                    log.warn("Cart id: [{}] not found", cartId);
                    return new NotFoundException("cart.id.not.found", cartId);
                });
    }

    public List<CartResponse> getListCarts() {
        return repository.cartsNotDeleted()
                .stream()
                .filter(Objects::nonNull)
                .map(CartResponse::new)
                .toList();
    }

    public CartResponse saveCart(CartRequest request) {
        Client client = clientService.getClientById(request.clientId());
        List<Product> productList = productService.searchProducts(new ProductSearchQueryRequest(request.productsIds()));

        Cart cart = new Cart();
        cart.setClient(client);
        cart.addProduct(productList);
        cart.setTotalPrice(getTotalPrice(cart.getProductList()));

        return new CartResponse(repository.save(cart));
    }

    private BigDecimal getTotalPrice(List<Product> products) {
        return products.stream()
                .map(Product::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
