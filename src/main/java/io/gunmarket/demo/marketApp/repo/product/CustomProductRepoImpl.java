package io.gunmarket.demo.marketApp.repo.product;

import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.web.RequestParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@Slf4j
@Repository
public class CustomProductRepoImpl implements CustomProductRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllByParameters(Set<RequestParameter> requestParams) {
		String nativeQuery = buildNativeQueryByParams(requestParams);
		log.debug("Native query: {}", nativeQuery);
		List resultList = entityManager.createQuery(nativeQuery).getResultList();
		log.debug("Result product list: {}", resultList);
		return resultList;
	}

	private String buildNativeQueryByParams(Set<RequestParameter> parameters) {
		StringJoiner result = new StringJoiner(" AND ");
		parameters.forEach(parameter -> result.add(parameter.getName() + " IN " + "(" + parameter.getValue() + ")"));
		return "FROM Product WHERE " + result;
	}

}
