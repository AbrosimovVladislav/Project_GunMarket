package com.gunmarket.web;

import com.gunmarket.model.Shop;
import com.gunmarket.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/shops", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Shop> getShops() {
        return shopService.getAllShops();
    }

}