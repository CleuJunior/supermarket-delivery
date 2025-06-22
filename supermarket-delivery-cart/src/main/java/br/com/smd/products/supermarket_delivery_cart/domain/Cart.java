package br.com.smd.products.supermarket_delivery_cart.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("cart-entity")
public class Cart extends Entity {

    private Client client;
    private final List<Product> productList = new ArrayList<>();
    @Field("total_price")
    private BigDecimal totalPrice;
    private boolean delivered;

    public void addProduct(List<Product> products) {
        productList.addAll(products);
    }

}
