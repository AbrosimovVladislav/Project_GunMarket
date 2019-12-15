package io.gunmarket.demo.marketApp.repo.productInShop;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.repo.querybuilder.QueryBuilder;
import io.gunmarket.demo.marketApp.web.RequestParameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;


@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomProductInShopRepoImpl implements CustomProsuctInShopRepo {
	private final QueryBuilder queryBuilder;
	@PersistenceContext private EntityManager entityManager;

	@Override
	public List<ProductInShop> findAllByParameters(Set<RequestParameter> requestParams) {
		String nativeQuery = queryBuilder.buildNativeQueryByParams(requestParams);
		log.debug("Native query: {}", nativeQuery);
		List<ProductInShop> resultList = entityManager.createQuery(nativeQuery, ProductInShop.class).getResultList();
		log.debug("Result product list: {}", resultList);
		return resultList;
	}

	public List<ProductInShop> findAllByParams(String dsl) {
		return entityManager.createQuery(queryBuilder.createCriteriaQuery(entityManager.getCriteriaBuilder(), dsl))
				.getResultList();
	}
}
