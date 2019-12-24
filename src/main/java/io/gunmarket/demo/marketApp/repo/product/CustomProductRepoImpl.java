package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.Product;
import io.gunmarket.demo.marketApp.repo.querybuilder.QueryBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
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
    public List<Product> findAllByParameters(Map<String, String> requestParams, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery =
                queryBuilder.createCriteriaQueryFromParamMap(criteriaBuilder, requestParams, Product.class);
        queryBuilder.addSort(criteriaBuilder, criteriaQuery, pageable);
        TypedQuery<Product> productQuery = entityManager.createQuery(criteriaQuery);
        productQuery = addPagination(productQuery, pageable);
        return productQuery.getResultList();
    }

    private TypedQuery<Product> addPagination(TypedQuery<Product> productQuery, Pageable pageable) {
        productQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
        productQuery.setMaxResults(pageable.getPageSize());
        return productQuery;
    }

}
