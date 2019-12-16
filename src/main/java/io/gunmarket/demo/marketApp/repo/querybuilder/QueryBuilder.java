package io.gunmarket.demo.marketApp.repo.querybuilder;

import io.gunmarket.demo.marketApp.domain.BasicEntity;
import io.gunmarket.demo.marketApp.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QueryBuilder {

    private final QBParamExtractor qbParamExtractor;

    //Actual flow with dsl from controller
    public <BE extends BasicEntity> CriteriaQuery<BE> createCriteriaQueryFromDsl(CriteriaBuilder criteriaBuilder, String dsl, Class<BE> entityClass) {
        List<QBParam> dslParams = parseDsl(dsl);

        CriteriaQuery<BE> criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root<BE> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);

        Predicate[] predicates = dslParams.stream()
                .map(qbparam -> createSinglePredicate(criteriaBuilder, root, qbparam))
                .toArray(Predicate[]::new);
        criteriaQuery.where(predicates);
        return criteriaQuery;
    }

    private Predicate createSinglePredicate(CriteriaBuilder criteriaBuilder, Root root, QBParam qbParam) {
        List<String> entities = qbParam.entities;
        Path path;
        if (entities.isEmpty()) {
            path = root.get(qbParam.paramName);
        } else {
            path = root.join(entities.get(0));
            for (int i = 1; i < entities.size(); i++) {
                path = ((Join) path).join(entities.get(i));
            }
            path = path.get(qbParam.paramName);
        }
        return qbParam.operation.getPredicate(qbParam.paramValue, criteriaBuilder, path);
    }

    private List<QBParam> parseDsl(String dsl) {
        return Arrays.stream(dsl.split("@"))
                .map(paramKV -> paramKV.split("="))
                .map(ar -> new AbstractMap.SimpleEntry<>(ar[0], ar[1]))
                .map(e -> qbParamExtractor.extractQbParam(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    //Secondary flow with paramMap from controller
    public CriteriaQuery<Product> createCriteriaQueryFromParamMap(CriteriaBuilder criteriaBuilder,
                                                                  Map<String, String> params) {
        List<QBParam> dslParams = parseParamMap(params);
        dslParams.forEach(System.out::println);

        CriteriaQuery<Product> cq = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        return null;
    }

    private List<QBParam> parseParamMap(Map<String, String> params) {
        return new ArrayList<>();
    }

}
