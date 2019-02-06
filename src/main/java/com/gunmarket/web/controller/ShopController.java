package com.gunmarket.web.controller;

import com.gunmarket.model.Shop;
import com.gunmarket.service.ShopService;
import com.gunmarket.web.webEntity.HttpParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import static com.gunmarket.model.Shop.*;
import static com.gunmarket.web.webEntity.HttpParameter.*;

@RestController
public class ShopController implements BasicController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/shops", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<? super Shop> getShopsByParams(
            @RequestParam(value = SHOP_ADDRESS, required = false) String address,
            @RequestParam(value = SHOP_PRODUCTS, required = false) String products
    ) {
        return shopService.getShopsByParams(
                returnParams(new HashMap<HttpParameter, String>() {
                    {
                        put(new HttpParameter(SHOP_ADDRESS, SIMPLE_PARAM_TYPE, PARAM_CLASS_STRING, SHOP_ENTITY), address);
                        put(new HttpParameter(SHOP_PRODUCTS, COMPLEX_PARAM_TYPE, PARAM_CLASS_LONG, SHOP_ENTITY), products);
                    }
                }));
    }

}
