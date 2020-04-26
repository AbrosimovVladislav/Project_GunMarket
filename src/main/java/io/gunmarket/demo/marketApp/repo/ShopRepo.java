package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.model.domain.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Long> {}
