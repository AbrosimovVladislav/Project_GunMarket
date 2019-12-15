package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.querybuilder.QueryBuilder;
import io.gunmarket.demo.marketApp.web.RequestParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@Slf4j
@Repository
public class CustomProductRepoImpl implements CustomProductRepo {

	private final QueryBuilder queryBuilder;

	@PersistenceContext
	private EntityManager entityManager;

	public CustomProductRepoImpl(QueryBuilder queryBuilder) {
		this.queryBuilder = queryBuilder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllByParameters(Set<RequestParameter> requestParams) {
		String nativeQuery = queryBuilder.buildNativeQueryByParams(requestParams);
		log.debug("Native query: {}", nativeQuery);
		List<Product> resultList = entityManager.createQuery(nativeQuery, Product.class).getResultList();
		log.debug("Result product list: {}", resultList);
		return resultList;
	}



}
