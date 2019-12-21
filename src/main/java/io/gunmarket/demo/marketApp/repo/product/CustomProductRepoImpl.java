package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.querybuilder.QueryBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomProductRepoImpl implements CustomProductRepo {

	@PersistenceContext private final EntityManager entityManager;

	private final QueryBuilder queryBuilder;

	@Override
	public List<Product> findAllByParameters(Map<String, String> requestParams, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Product> criteriaQuery =
				queryBuilder.createCriteriaQueryFromParamMap(criteriaBuilder, requestParams, Product.class);

		queryBuilder.addSort(criteriaBuilder, criteriaQuery, pageable);

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
