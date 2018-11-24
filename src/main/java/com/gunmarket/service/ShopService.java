package com.gunmarket.service;

import com.gunmarket.model.Shop;
import com.gunmarket.repository.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopService {

    private final Class SHOP_CLASS = Shop.class;

    @Autowired
    private ShopRepo shopRepo;

    public List<Shop> getAllShops() {
        return shopRepo.getAll(SHOP_CLASS);
    }

}
