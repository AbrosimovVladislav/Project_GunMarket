package com.gunmarket.service;

import com.gunmarket.model.Shop;
import com.gunmarket.repository.ShopRepo;
import com.gunmarket.web.webEntity.HttpParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShopService {

    private static final Class SHOP_CLASS = Shop.class;
    private static final String SHOP_NAME = "Shop";

    @Autowired
    private ShopRepo shopRepo;

    public List<? super Shop> getShopsByParams(Map<HttpParameter, List<String>> params) {
        return shopRepo.getByParamsDueHql(SHOP_NAME, params);
    }

}
