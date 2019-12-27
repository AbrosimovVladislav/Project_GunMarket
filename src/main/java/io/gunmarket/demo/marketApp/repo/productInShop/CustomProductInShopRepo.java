package io.gunmarket.demo.marketApp.repo.productInShop;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CustomProductInShopRepo {
	List<ProductInShop> findAllByParameters(Map<String, String> requestParams, Pageable pageable);
}
