package io.gunmarket.demo.marketApp.repo.searchProductRepo;

import io.gunmarket.demo.marketApp.model.domain.Product;

import java.util.List;

public interface SearchProductRepo {

    List<Product> searchByQuery(String query);

}
