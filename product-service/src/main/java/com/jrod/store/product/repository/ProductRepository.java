package com.jrod.store.product.repository;

import com.jrod.store.product.repository.entity.Category;
import com.jrod.store.product.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByCategory(Category category);
}
