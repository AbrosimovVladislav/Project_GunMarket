package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.repo.filterandsorting.FilterAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductInShopRepo extends JpaRepository<ProductInShop, Long>, FilterAndSortingRepository<ProductInShop> {
	@Query(value = "SELECT MIN(price) FROM product_in_shop WHERE product_id = :productId", nativeQuery = true)
	Double calculateMinPriceByProduct(Long productId);
}
