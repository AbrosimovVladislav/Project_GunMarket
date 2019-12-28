package io.gunmarket.demo.marketApp.web.validation;

import io.gunmarket.demo.marketApp.domain.BasicEntity;
import io.gunmarket.demo.marketApp.domain.Product;
import io.gunmarket.demo.marketApp.domain.ProductInShop;
import io.gunmarket.demo.marketApp.domain.Rating;
import io.gunmarket.demo.marketApp.web.webentities.FilterAndPageable;
import org.jsoup.internal.StringUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RequestParamsValidator {

	public FilterAndPageable validate(Map<String, String> requestParams,
	                           Pageable pageable,
	                           Class<? extends BasicEntity> entityClass) {
		FilterAndPageable filterAndPageable = new FilterAndPageable(requestParams, pageable);
		sortingValidation(filterAndPageable, entityClass);
		paginationValidation(filterAndPageable);
		return filterAndPageable;
	}

	private void sortingValidation(FilterAndPageable filterAndPageable, Class<? extends BasicEntity> entityClass) {
		Pageable pageable = filterAndPageable.getPageable();
		String sortParam = filterAndPageable.getFilter().remove("sort");
		if (sortParam == null) {
			filterAndPageable.setPageable(getDefaultSortingProperty(pageable, entityClass));
} else {
		String sortProp = sortParam.substring(0, sortParam.indexOf(","));
		Sort sort = Sort.by(pageable.getSort().getOrderFor(sortProp));
		filterAndPageable.setPageable(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort));
		}
		}

	private void paginationValidation(FilterAndPageable filterAndPageable) {
		Pageable pageable = filterAndPageable.getPageable();
		String page = filterAndPageable.getFilter().remove("page");
		String size = filterAndPageable.getFilter().remove("size");

		if (StringUtil.isNumeric(page)) {
			filterAndPageable.setPageable(PageRequest.of(Integer.parseInt(page),
					pageable.getPageSize(),
					pageable.getSort()
			));
		}
		if (StringUtil.isNumeric(size)) {
			filterAndPageable.setPageable(PageRequest.of(pageable.getPageNumber(),
					Integer.parseInt(size),
					pageable.getSort()
			));
		}
	}

	private static PageRequest getDefaultSortingProperty(Pageable pageable, Class<? extends BasicEntity> entityClass) {
		String sortingProperty = "";
		Sort.Direction dir = Sort.Direction.ASC;
		if(entityClass.isAssignableFrom(Product.class)){
			sortingProperty = Rating.RATING_VALUE_SORT;
		} else if(entityClass.isAssignableFrom(ProductInShop.class)){
			sortingProperty = ProductInShop.PRODUCT_IN_SHOP_POPULARITY;
			dir = Sort.Direction.DESC;
		}
		return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(dir, sortingProperty));
	}}