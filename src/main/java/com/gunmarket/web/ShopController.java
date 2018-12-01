package com.gunmarket.web;

import com.gunmarket.model.Shop;
import com.gunmarket.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gunmarket.model.Shop.SHOP_ADDRESS;
import static com.gunmarket.model.Shop.SHOP_NAME;
import static com.gunmarket.model.Shop.SHOP_PRODUCTS;

@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/shops", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Shop> getShopsByParams(@RequestParam(value = SHOP_NAME, required = false) String name
            , @RequestParam(value = SHOP_ADDRESS, required = false) String address
            , @RequestParam(value = SHOP_PRODUCTS, required = false) String products) {
        Map<String, List<String>> params = new HashMap<String, List<String>>();
        if (name != null) {
            params.put(SHOP_NAME, Arrays.asList(name.split(",")));
        }
        if (address != null) {
            params.put(SHOP_ADDRESS, Arrays.asList(address.split(",")));
        }
        if (products != null) {
            params.put(SHOP_PRODUCTS, Arrays.asList(products.split(",")));
        }

        return shopService.getShopsByParams(params);
    }

}
