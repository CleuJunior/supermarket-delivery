package br.com.smd.products.supermarket_delivery_cart.repository;

import br.com.smd.products.supermarket_delivery_cart.domain.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    @Query("{'deleted': false}")
    List<Cart> cartsNotDeleted();
}
