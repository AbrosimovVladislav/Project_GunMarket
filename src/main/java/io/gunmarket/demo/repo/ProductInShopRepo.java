package io.gunmarket.demo.repo;

import io.gunmarket.demo.domain.ProductInShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInShopRepo extends JpaRepository<ProductInShop, Long> {}
