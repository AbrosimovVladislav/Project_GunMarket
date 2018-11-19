package com.gunmarket.service;

import com.gunmarket.model.Shop;
import com.gunmarket.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final String SHOP_ENTITY = "Shop";
    private final Class SHOP_CLASS = Shop.class;

    @Autowired
    private ShopRepo shopRepo;

    public void addShop(Shop shop) {
        shopRepo.add(shop);
    }

    public Shop getShopByParam(String paramName, String paramValue) {
        return (Shop) shopRepo.getByParam(paramName, paramValue, SHOP_ENTITY, SHOP_CLASS);
    }

    public List<Shop> getAllShops() {
        return shopRepo.getAll(SHOP_ENTITY, SHOP_CLASS);
    }

}
