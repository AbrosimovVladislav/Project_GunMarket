package io.gunmarket.demo.marketApp.repo.querybuilder;

import io.gunmarket.demo.marketApp.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.gunmarket.demo.marketApp.domain.Brand.BRAND_SHORT_NAME;
import static io.gunmarket.demo.marketApp.domain.Brand.BRAND_TABLE;
import static io.gunmarket.demo.marketApp.domain.product.Product.PRODUCT_AVG_PRICE;

@Component
@RequiredArgsConstructor
public class QueryBuilder {

	private final QBParamExtractor qbParamExtractor;

	//Actual flow with dsl from controller
	public CriteriaQuery<Product> createCriteriaQueryFromDsl(CriteriaBuilder criteriaBuilder, String dsl) {
		List<QBParam> dslParams = parseDsl(dsl);

		CriteriaQuery<Product> productCriteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = productCriteriaQuery.from(Product.class);
		productCriteriaQuery.select(root);

		productCriteriaQuery.where(
				criteriaBuilder.equal(root.get(BRAND_TABLE).get(BRAND_SHORT_NAME), "brand-name1"),
				criteriaBuilder.equal(root.get(PRODUCT_AVG_PRICE), 100)
		);

		Predicate[] predicates = dslParams.stream()
				.map(qbparam -> createSinglePredicate(criteriaBuilder, root, qbparam))
				.toArray(Predicate[]::new);
		productCriteriaQuery.where(predicates);
		return productCriteriaQuery;
	}

	private Predicate createSinglePredicate(CriteriaBuilder criteriaBuilder, Root root, QBParam qbParam) {
		List<String> entities = qbParam.entities;
		Path path;
		//ToDo не работает при связи OneToMany(Когда коллекция ожидается), надо применить join
		if (entities.isEmpty()) {
			path = root.get(qbParam.paramName);
		} else {
			path = root.get(entities.get(0));
			for (int i = 1; i < entities.size(); i++) {
				path = path.get(entities.get(i));
			}
			path = path.get(qbParam.paramName);
		}

		switch (qbParam.operation) {
			case IN:
				CriteriaBuilder.In inClause = criteriaBuilder.in(path);
				for (String value : qbParam.paramValue.split(",")) {
					inClause.value(value);
				}
				return inClause;
			case EQUALS:
				return criteriaBuilder.equal(path, qbParam.paramValue);
			case BETWEEN:
				String[] interval = qbParam.paramValue.split("interval");
				return criteriaBuilder.between(path, Double.valueOf(interval[0]),Double.valueOf(interval[1]));
			default:
				throw new UnsupportedOperationException("Operation "+ qbParam.operation + " is INVALID");
		}
	}

	private List<QBParam> parseDsl(String dsl) {
		return Arrays.stream(dsl.split("@"))
				.map(paramKV -> paramKV.split("="))
				.map(ar -> new AbstractMap.SimpleEntry<>(ar[0], ar[1]))
				.map(e -> qbParamExtractor.extractQbParam(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
	}

	//Secondary flow with paramMap from controller
	public CriteriaQuery<Product> createCriteriaQueryFromParamMap(CriteriaBuilder criteriaBuilder,
	                                                              Map<String, String> params) {
		List<QBParam> dslParams = parseParamMap(params);
		dslParams.forEach(System.out::println);

		CriteriaQuery<Product> cq = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		return null;
	}

	private List<QBParam> parseParamMap(Map<String, String> params) {
		return new ArrayList<>();
	}

}
