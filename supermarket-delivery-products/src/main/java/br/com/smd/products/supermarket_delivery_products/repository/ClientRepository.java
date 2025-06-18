package br.com.smd.products.supermarket_delivery_products.repository;

import br.com.smd.products.supermarket_delivery_products.domain.Client;
import br.com.smd.products.supermarket_delivery_products.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    @Query("{'deleted': false}")
    List<Client> clientsNotDeleted();
}
