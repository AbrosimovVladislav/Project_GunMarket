package io.gunmarket.demo.marketApp.repo.productInShop;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductInShopRepo extends JpaRepository<ProductInShop, Long> {

}
