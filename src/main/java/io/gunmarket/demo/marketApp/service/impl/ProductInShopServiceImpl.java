package io.gunmarket.demo.marketApp.service.impl;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.service.ProductInShopService;
import io.gunmarket.demo.marketApp.web.RequestParameter;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ProductInShopServiceImpl implements ProductInShopService {

//    private final ProductRepo productRepo;

//    public ProductServiceImpl(ProductRepo productRepo) {
//        this.productRepo = productRepo;
//    }

    public List<ProductInShop> getAllByParameters(Set<RequestParameter> requestParams) {
        return Collections.singletonList(new ProductInShop());
//        return productRepo.findAllByParameters(requestParams);
    }

}
