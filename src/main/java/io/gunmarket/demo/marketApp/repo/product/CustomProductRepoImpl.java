package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.querybuilder.QueryBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomProductRepoImpl implements CustomProductRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    private final QueryBuilder queryBuilder;

    @Override
    public List<Product> findAllByParameters(Map<String, String> requestParams) {
        CriteriaQuery<Product> criteriaQuery =
                queryBuilder.createCriteriaQueryFromParamMap(entityManager.getCriteriaBuilder(), requestParams, Product.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
