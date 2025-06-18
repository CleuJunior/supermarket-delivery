package br.com.smd.products.supermarket_delivery_products.seed;

import br.com.smd.products.supermarket_delivery_products.domain.Product;
import br.com.smd.products.supermarket_delivery_products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductSeed {

    private final ProductRepository repository;

    @Bean
    public CommandLineRunner seedProduct() {
        return args -> {
            List<Product> check = repository.findAll();

            if (check.isEmpty()) {
                List<Product> products = repository.saveAll(this.listProducts());
                log.info("Seeding product database: [{}]", products);
            }
        };
    }

    private List<Product> listProducts() {
        Product product1 = new Product();
        product1.setName("Refrigerante");
        product1.setBrand("Coca-Cola");
        product1.setPrice(new BigDecimal("7.47"));
        product1.setDueDate(ZonedDateTime.now().plusMonths(7));
        product1.setQuantity(50);
        product1.setInStock(true);
        product1.setDeleted(false);

        Product product2 = new Product();
        product2.setName("Arroz");
        product2.setBrand("Sant' Thiago");
        product2.setPrice(new BigDecimal("11.39"));
        product2.setDueDate(ZonedDateTime.now().plusMonths(7));
        product2.setQuantity(20);
        product2.setInStock(true);
        product2.setDeleted(true);

        Product product3 = new Product();
        product3.setName("Bisteca de Buffalo");
        product3.setBrand("Buffalo Bill");
        product3.setPrice(new BigDecimal("23.12"));
        product3.setDueDate(ZonedDateTime.now().plusMonths(7));
        product3.setQuantity(2);
        product3.setInStock(false);
        product3.setDeleted(false);

        return List.of(product1, product2, product3);
    }

}
