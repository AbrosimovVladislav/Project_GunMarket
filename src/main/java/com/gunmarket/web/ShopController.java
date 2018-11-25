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

@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

/*    @RequestMapping(value = "/shopsByParams", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Shop> getShopsByParams(@RequestParam(value = PRICE_NAME, required = false) String price
            , @RequestParam(value = TYPEID_NAME, required = false) String typeId) {
        Map<String,List<String>> params = new HashMap<String,List<String>>();
        if(price!=null){
            params.put(PRICE_NAME, Arrays.asList(price.split(",")));
        }
        if(typeId!=null){
            params.put(TYPEID_NAME, Arrays.asList(typeId.split(",")));
        }

        return productService.getProductsByParams(params);
    }*/

    @RequestMapping(value = "/allShops", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Shop> getShops() {
        return shopService.getAllShops();
    }

}