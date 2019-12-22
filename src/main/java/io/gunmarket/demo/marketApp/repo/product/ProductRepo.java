package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product, Long>, CustomProductRepo {}
