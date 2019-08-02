package io.gunmarket.demo.product.repo;

import io.gunmarket.demo.product.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Long> {}
