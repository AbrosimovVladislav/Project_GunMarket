package com.gunmarket.service;

import com.gunmarket.model.Product;
import com.gunmarket.repository.ProductRepo;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private static final Class PRODUCT_CLASS = Product.class;
    public static final String PRODUCT_ENTITY = "Product";

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProductsByParams(Map<Pair<String,String>, List<String>> params) {
        return productRepo.getByParamsDueHql(PRODUCT_ENTITY, params);
    }

}
