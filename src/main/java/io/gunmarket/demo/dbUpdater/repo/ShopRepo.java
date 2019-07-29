package io.gunmarket.demo.dbUpdater.repo;

import io.gunmarket.demo.product.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Long> {}
