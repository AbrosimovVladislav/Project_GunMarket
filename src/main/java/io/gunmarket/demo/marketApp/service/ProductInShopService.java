package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.web.RequestParameter;

import java.util.List;
import java.util.Set;

public interface ProductInShopService {
    List<ProductInShop> getAllByParameters(Set<RequestParameter> requestParams);
}
