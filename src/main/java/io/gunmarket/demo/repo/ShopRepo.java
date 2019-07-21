package io.gunmarket.demo.repo;

import io.gunmarket.demo.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Long> {}
