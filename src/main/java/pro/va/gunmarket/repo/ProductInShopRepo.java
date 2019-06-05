package pro.va.gunmarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.va.gunmarket.domain.ProductInShop;

public interface ProductInShopRepo extends JpaRepository<ProductInShop, Long> {}
