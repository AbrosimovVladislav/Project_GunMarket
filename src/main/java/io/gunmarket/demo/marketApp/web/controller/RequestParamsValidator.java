package io.gunmarket.demo.marketApp.web.controller;

import org.jsoup.internal.StringUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Map;

import static io.gunmarket.demo.marketApp.domain.Rating.RATING_VALUE_SORT;

@Component
public class RequestParamsValidator {

	FilterAndPageable validate(Map<String, String> requestParams, Pageable pageable) {
		FilterAndPageable filterAndPageable = new FilterAndPageable(requestParams, pageable);
		sortingValidation(filterAndPageable);
		paginationValidation(filterAndPageable);
		return filterAndPageable;
	}

	private void sortingValidation(FilterAndPageable filterAndPageable) {
		Pageable pageable = filterAndPageable.getPageable();
		String sortParam = filterAndPageable.getFilter().remove("sort");
		if (sortParam == null) {
			filterAndPageable.setPageable(getDefaultSortingProperty(pageable));
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

	private static PageRequest getDefaultSortingProperty(Pageable pageable) {
		return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(RATING_VALUE_SORT));
	}

}