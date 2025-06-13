package br.com.smd.products.supermarket_delivery_products.domain;

import br.com.smd.products.supermarket_delivery_products.dto.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("product")
public class Product extends Entity {

    @Indexed
    private String name;
    @Indexed
    private String brand;
    private BigDecimal price;
    private ZonedDateTime dueDate;
    private int quantity;
    private boolean inStock;

    public Product(ProductRequest request) {
        this.name = request.name();
        this.brand = request.brand();
        this.price = request.price();
        this.dueDate = request.dueDate();
        this.quantity = request.quantity();
        this.inStock = request.inStock();
    }
}
