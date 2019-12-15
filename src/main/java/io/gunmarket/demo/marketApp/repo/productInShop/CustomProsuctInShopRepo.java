package io.gunmarket.demo.marketApp.repo.productInShop;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.web.RequestParameter;

import java.util.List;
import java.util.Set;

public interface CustomProsuctInShopRepo {
    List<ProductInShop> findAllByParameters(Set<RequestParameter> requestParams);
}
