package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.model.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Long> {}
