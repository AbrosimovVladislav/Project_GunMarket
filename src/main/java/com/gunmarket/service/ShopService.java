package com.gunmarket.service;

import com.gunmarket.model.Shop;
import com.gunmarket.repository.ShopRepo;
import com.gunmarket.web.webEntity.HttpParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.gunmarket.model.Shop.SHOP_ENTITY;

@Service
public class ShopService {

    @Autowired
    private ShopRepo shopRepo;

    public List<? super Shop> getShopsByParams(Map<HttpParameter, List<String>> params) {
        return shopRepo.getByParamsDueHql(SHOP_ENTITY, params);
    }

}
