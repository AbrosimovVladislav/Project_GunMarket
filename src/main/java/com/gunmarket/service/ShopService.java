package com.gunmarket.service;

import com.gunmarket.model.Shop;
import com.gunmarket.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private static final Class SHOP_CLASS = Shop.class;
    private static final String SHOP_NAME = "Shop";

    @Autowired
    private ShopRepo shopRepo;

    public List<Shop> getAllShops() {
        return shopRepo.getAll(SHOP_NAME, SHOP_CLASS);
    }

}
