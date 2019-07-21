package io.gunmarket.demo.product.repo.impl;

import io.gunmarket.demo.product.domain.product.Product;
import io.gunmarket.demo.product.repo.ProductRepo;
import io.gunmarket.demo.product.web.RequestParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;


@Slf4j
@Repository
public class ProductRepoImpl implements ProductRepo {
	@PersistenceContext private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllByParameters(Set<RequestParameter> requestParams) {
		String nativeQuery = buildNativeQueryByParams(requestParams);
		return entityManager.createQuery(nativeQuery).getResultList();
	}

	private String buildNativeQueryByParams(Set<RequestParameter> parameters) {
		StringJoiner result = new StringJoiner(" AND ");
		parameters.forEach(parameter -> result.add(parameter.getName() + " IN " + "(" + parameter.getValue() + ")"));
		return "FROM Product WHERE " + result;
	}
}
