package io.gunmarket.demo.marketApp.repo.productInShop;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInShopRepo extends JpaRepository<ProductInShop, Long>, CustomProductInShopRepo {
	ProductInShop findAllByProductInShopId(String productInShopId);
}
