package io.gunmarket.demo.marketApp.repo.productInShop;

import io.gunmarket.demo.marketApp.domain.ProductInShop;
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
public class CustomProductInShopRepoImpl implements CustomProductInShopRepo{

	@PersistenceContext
	private final EntityManager entityManager;
	private final QueryBuilder queryBuilder;

	@Override
	public List<ProductInShop> findAllByParameters(Map<String, String> requestParams, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProductInShop> criteriaQuery =
				queryBuilder.createCriteriaQueryFromParamMap(criteriaBuilder, requestParams, ProductInShop.class);
		queryBuilder.addSort(criteriaBuilder, criteriaQuery, pageable);
		TypedQuery<ProductInShop> productInShopQuery = entityManager.createQuery(criteriaQuery);
		productInShopQuery = addPagination(productInShopQuery, pageable);
		return productInShopQuery.getResultList();
	}

	private TypedQuery<ProductInShop> addPagination(TypedQuery<ProductInShop> productInShopQuery, Pageable pageable) {
		productInShopQuery.setFirstResult(pageable.getPageSize() * pageable.getPageNumber());
		productInShopQuery.setMaxResults(pageable.getPageSize());
		return productInShopQuery;
	}

}
