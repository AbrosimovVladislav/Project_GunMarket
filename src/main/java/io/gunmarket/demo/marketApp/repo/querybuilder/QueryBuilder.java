package io.gunmarket.demo.marketApp.repo.querybuilder;

import io.gunmarket.demo.marketApp.domain.BasicEntity;
import io.gunmarket.demo.marketApp.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QueryBuilder {

    private final QBParamExtractor qbParamExtractor;

    public <BE extends BasicEntity> CriteriaQuery<BE> createCriteriaQueryFromParamMap(CriteriaBuilder criteriaBuilder,
                                                                  Map<String, String> requestParams, Class<BE> entityClass) {
        List<QBParam> dslParams = parseRequestParamMap(requestParams);

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

    private List<QBParam> parseRequestParamMap(Map<String, String> requestParams) {
        return requestParams.entrySet().stream()
                .map(e -> qbParamExtractor.extractQbParam(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

}
