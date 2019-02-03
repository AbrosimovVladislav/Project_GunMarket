package com.gunmarket.service;

import com.gunmarket.model.product.Product;
import com.gunmarket.repository.ProductRepo;
import com.gunmarket.web.webEntity.HttpParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    public static final String PRODUCT_ENTITY = "Product";

    @Autowired
    private ProductRepo productRepo;

    public List<? super Product> getProductsByParams(Map<HttpParameter, List<String>> params) {
        return productRepo.getByParamsDueHql(PRODUCT_ENTITY, params);
    }

}
