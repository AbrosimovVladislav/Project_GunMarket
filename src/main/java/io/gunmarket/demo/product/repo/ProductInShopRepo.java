package io.gunmarket.demo.product.repo;

import io.gunmarket.demo.product.domain.ProductInShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductInShopRepo extends JpaRepository<ProductInShop, Long> {

	@Query("UPDATE ProductInShop pis " +
			       "SET pis.additionalInfo =:additionalInfo," +
			       "pis.inStock =:inStock," +
			       "pis.link =:link," +
			       "pis.price =:price," +
			       "pis.sale =:sale " +
			       "WHERE pis.productInShopId =:productInShopId")
	ProductInShop update(@Param("productInShopId") long id,
	                     @Param("additionalInfo") String additionalInfo,
	                     @Param("inStock") boolean inStock,
	                     @Param("link") String link,
	                     @Param("price") double price,
	                     @Param("sale") int sale);
}
