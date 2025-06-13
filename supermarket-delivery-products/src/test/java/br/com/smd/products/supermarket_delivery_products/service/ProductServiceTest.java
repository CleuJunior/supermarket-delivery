package br.com.smd.products.supermarket_delivery_products.service;

import br.com.smd.products.supermarket_delivery_products.domain.Product;
import br.com.smd.products.supermarket_delivery_products.dto.request.ProductRequest;
import br.com.smd.products.supermarket_delivery_products.dto.response.ProductResponse;
import br.com.smd.products.supermarket_delivery_products.exception.NotFoundException;
import br.com.smd.products.supermarket_delivery_products.factory.ProductFactory;
import br.com.smd.products.supermarket_delivery_products.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {


    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductService subject;

    private Product product;
    private ProductResponse response;

    @BeforeEach
    void setUp() {
        product = ProductFactory.buildProduct();
        response = ProductFactory.buildProductResponse();
    }


    @Test
    void findById_ShouldReturnProductByExistingId() {
        String id = "684c6544205c7e6876a137d7";

        given(repository.findById(id))
                .willReturn(Optional.of(product));

        ProductResponse result = subject.findById(id);

        then(result).isNotNull();
        then(result).isEqualTo(response);

        verify(repository).findById(id);
    }

    @Test
    void findById_ShouldThrowsNotFoundException_WhenIdNotF() {
        given(repository.findById(anyString()))
                .willReturn(Optional.empty());

        assertThrows(NotFoundException.class,
                () -> subject.findById("product-id")
        );

        verify(repository).findById(anyString());
    }

    @Test
    void saveProduct_ShouldSaveAndReturnProduct() {
        ProductRequest request = mock(ProductRequest.class);

        given(repository.save(any(Product.class)))
                .willReturn(product);

        ProductResponse result = subject.saveProduct(request);

        then(result).isNotNull();
        then(result).isEqualTo(response);

        verify(repository).save(any(Product.class));
    }
}