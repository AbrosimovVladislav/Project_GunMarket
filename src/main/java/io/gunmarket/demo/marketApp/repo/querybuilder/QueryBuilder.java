package io.gunmarket.demo.marketApp.repo.querybuilder;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.web.RequestParameter;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

import static io.gunmarket.demo.marketApp.domain.ProductInShop.PRODUCT_IN_SHOP_PRICE;


@Component
@RequiredArgsConstructor
public class QueryBuilder {
    private final QBParamExtractor qbParamExtractor;

    public String buildNativeQueryByParams(Set<RequestParameter> parameters) {
        StringJoiner result = new StringJoiner(" AND ");
        parameters.forEach(parameter -> result.add(parameter.getName() + " IN " + "(" + parameter.getValue() + ")"));
        return "FROM Product WHERE " + result;
    }

    /*
        dtype='Gun'&
        productInShop.price=5000interval10000&
        productInShop.Shop.Address.Street='address1'&
        brand.shortName='brand-name1,brand-name2'&
        caliber.caliberValue='caliber-value1'
     */
    private List<QBParam> parseDsl(String dsl) {
        for (String paramKV : dsl.split("&")) {
            String[] param = paramKV.split("=");
            String paramKey = param[0]; // param name
            String paramValue = param[1];
            QBParam qbParam = qbParamExtractor.extractQbParam(paramKey, paramValue);
        }
    }

    public CriteriaQuery<ProductInShop> createCriteriaQuery(CriteriaBuilder criteriaBuilder) {
        Map<String, Object> dslParams = new HashMap<>(); dslParams.put(RandomString.make(), new Object());

        CriteriaQuery<ProductInShop> cq = criteriaBuilder.createQuery(ProductInShop.class);
        Root<ProductInShop> root = cq.from(ProductInShop.class);

        criteriaBuilder.equal(root.get(PRODUCT_IN_SHOP_PRICE), dslParams.get("price"));


        /*
    In<String> inClause = criteriaBuilder.in(root.get("title"));
    for (String title : titles) {
        inClause.value(title);
    }
    criteriaQuery.select(root).where(inClause);
         */
    }
}
