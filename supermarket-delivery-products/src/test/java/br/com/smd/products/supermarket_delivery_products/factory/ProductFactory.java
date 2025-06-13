package br.com.smd.products.supermarket_delivery_products.factory;


import br.com.smd.products.supermarket_delivery_products.domain.Product;
import br.com.smd.products.supermarket_delivery_products.dto.response.ProductResponse;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class ProductFactory {

    private static final String ID = "684c6544205c7e6876a137d7";
    private static final String NAME = "Refrigerante";
    private static final String BRAND = "Coca-Cola";
    private static final BigDecimal PRICE = new BigDecimal("7.47");
    private static final ZonedDateTime DUE_DATE = ZonedDateTime.now().plusMonths(7);
    private static final int QUANTITY = 50;
    private static final boolean IN_STOCK = true;
    private static final ZonedDateTime LAST_MODIFIED_DATE = ZonedDateTime.now();
    private static final ZonedDateTime CREATION_DATE = ZonedDateTime.now().minusYears(3);
    private static final boolean DELETED = false;

    public static Product buildProduct() {
        Product product = new Product();
        product.setId(ID);
        product.setName(NAME);
        product.setBrand(BRAND);
        product.setPrice(PRICE);
        product.setDueDate(DUE_DATE);
        product.setQuantity(QUANTITY);
        product.setInStock(IN_STOCK);
        product.setCreationDate(CREATION_DATE);
        product.setLastModifiedDate(LAST_MODIFIED_DATE);
        product.setDeleted(DELETED);

        return product;
    }

    public static ProductResponse buildProductResponse() {
        return new ProductResponse(
                ID, NAME, BRAND, PRICE, DUE_DATE, QUANTITY, IN_STOCK, DELETED, CREATION_DATE, LAST_MODIFIED_DATE
        );
    }

}
