package com.jrod.store.product;

import com.jrod.store.product.repository.entity.Category;
import com.jrod.store.product.repository.entity.Product;
import com.jrod.store.product.repository.ProductRepository;
import com.jrod.store.product.service.ProductService;
import com.jrod.store.product.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .name("computer")
                .id(1L)
                .category(Category.builder().id(1L).build())
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("1240.90"))
                .status("Created")
                .createAt(new Date()).build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer))
                .thenReturn(computer);

    }

    @Test
    public void whenValidGetID_ThenReturnProduct() {
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidGUpdateStock_ThenReturnNewStock() {
        Product newStock = productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(17);
    }

}
