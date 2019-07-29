package io.gunmarket.demo.dbUpdater.repo;

import io.gunmarket.demo.product.domain.ProductInShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInShopRepo extends JpaRepository<ProductInShop,Long> {}
