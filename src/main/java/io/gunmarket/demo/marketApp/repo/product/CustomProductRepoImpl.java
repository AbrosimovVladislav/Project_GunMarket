package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.dslbuilder.DslBuilder;
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

	private final DslBuilder dslBuilder;

	//Actual flow with dsl from controller
	@Override
	public List<Product> findAllByParameters(String dsl) {
		CriteriaQuery<Product> criteriaQuery =
				queryBuilder.createCriteriaQueryFromDsl(entityManager.getCriteriaBuilder(), dsl);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	//Secondary flow with paramMap from controller
	@Override
	public List<Product> findAllByParameters(Map<String, String> params) {
		CriteriaQuery<Product> criteriaQuery =
				queryBuilder.createCriteriaQueryFromParamMap(entityManager.getCriteriaBuilder(), params);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
