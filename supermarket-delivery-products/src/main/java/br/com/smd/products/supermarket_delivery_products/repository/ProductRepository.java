package br.com.smd.products.supermarket_delivery_products.repository;

import br.com.smd.products.supermarket_delivery_products.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'deleted': false}")
    List<Product> productsNotDeleted();
}
