package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.Product;
import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.repo.ProductInShopRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductInShopService {

	private final ProductInShopRepo productInShopRepo;

	public ProductInShopService(ProductInShopRepo productInShopRepo) {
		this.productInShopRepo = productInShopRepo;
	}

	public List<ProductInShop> getAllByParameters(Map<String, String> requestParams, Pageable pageable) {
		return productInShopRepo.findAllByParameters(requestParams, pageable, Product.class);
	}

	public ProductInShop getById(String id)
	{
		return productInShopRepo.findAllByProductInShopId(id);
	}

}
