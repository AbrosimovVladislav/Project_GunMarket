package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.repo.filterandsorting.FilterAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInShopRepo extends JpaRepository<ProductInShop, Long>, FilterAndSortingRepository<ProductInShop> {
	ProductInShop findAllByProductInShopId(String productInShopId);
}
