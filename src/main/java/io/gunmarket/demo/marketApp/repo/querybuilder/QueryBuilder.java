package io.gunmarket.demo.marketApp.repo.querybuilder;

import io.gunmarket.demo.marketApp.domain.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QueryBuilder {

	private final QBParamExtractor qbParamExtractor;

	//Actual flow with dsl from controller
	public CriteriaQuery<Product> createCriteriaQueryFromDsl(CriteriaBuilder criteriaBuilder, String dsl) {
		List<QBParam> dslParams = parseDsl(dsl);
		dslParams.forEach(System.out::println);

		CriteriaQuery<Product> cq = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		return null;
	}

	private List<QBParam> parseDsl(String dsl) {
		return Arrays.stream(dsl.split("&"))
				.map(paramKV -> paramKV.split("="))
				.map(ar -> new AbstractMap.SimpleEntry<>(ar[0], ar[1]))
				.map(e -> qbParamExtractor.extractQbParam(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
	}

	//Secondary flow with paramMap from controller
	public CriteriaQuery<Product> createCriteriaQueryFromParamMap(CriteriaBuilder criteriaBuilder,
	                                                              Map<String,String> params) {
		List<QBParam> dslParams = parseParamMap(params);
		dslParams.forEach(System.out::println);

		CriteriaQuery<Product> cq = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = cq.from(Product.class);
		return null;
	}
	private List<QBParam> parseParamMap(Map<String,String> params){
		return new ArrayList<>();
	}

}
