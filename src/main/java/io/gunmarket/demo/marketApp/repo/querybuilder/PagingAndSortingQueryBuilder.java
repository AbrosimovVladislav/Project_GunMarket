package io.gunmarket.demo.marketApp.repo.querybuilder;

import io.gunmarket.demo.marketApp.domain.BasicEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PagingAndSortingQueryBuilder {

    private final QueryBuilder queryBuilder;

    public <BE extends BasicEntity> CriteriaQuery<BE> createPagingAndSortingCriteriaQuery(CriteriaBuilder criteriaBuilder, Map<String, String> requestParams, Class<BE> entityClass) {

        CriteriaQuery<BE> cq = queryBuilder.createCriteriaQueryFromParamMap(criteriaBuilder, requestParams, entityClass);
//        cq.orderBy(createSortingPredicate(criteriaBuilder, cq.from(entityClass)));
        cq.orderBy(createSortingPredicate(criteriaBuilder, cq.getRoots().iterator().next()));

        return cq;
    }

    private Order createSortingPredicate(CriteriaBuilder criteriaBuilder, Root root) {
        return criteriaBuilder.asc(root.get("rating").get("value"));
    }

    private Predicate createPagingPredicate() {
        return null;
    }


}
