package io.gunmarket.demo.repo;

import io.gunmarket.demo.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {}
