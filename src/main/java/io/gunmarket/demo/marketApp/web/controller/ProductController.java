package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.domain.Product;
import io.gunmarket.demo.marketApp.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jsoup.internal.StringUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static io.gunmarket.demo.marketApp.domain.Rating.RATING_VALUE_SORT;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 10;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Product> getAllByParams(@RequestParam Map<String, String> requestParams,
                                        @PageableDefault(size = DEFAULT_PAGE_SIZE, page = DEFAULT_PAGE_NUMBER) Pageable pageable) {
        FilterAndPageable pairOfParamsAndPageable = validate(requestParams, pageable);
        return productService.getAllByParameters(pairOfParamsAndPageable.filter, pairOfParamsAndPageable.pageable);
    }

    private FilterAndPageable validate(Map<String, String> requestParams, Pageable pageable) {
        FilterAndPageable filterAndPageable = new FilterAndPageable(requestParams, pageable);
        sortingValidation(filterAndPageable);
        paginationValidation(filterAndPageable);
        return filterAndPageable;
    }

    private void sortingValidation(FilterAndPageable filterAndPageable) {
        Pageable pageable = filterAndPageable.pageable;
        String sortParam = filterAndPageable.filter.remove("sort");
        if (sortParam == null) {
            filterAndPageable.pageable = getDefaultSortingProperty(pageable);
        } else {
            String sortProp = sortParam.substring(0, sortParam.indexOf(","));
            Sort sort = Sort.by(pageable.getSort().getOrderFor(sortProp));
            filterAndPageable.pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        }
    }

    private void paginationValidation(FilterAndPageable filterAndPageable) {
        Pageable pageable = filterAndPageable.pageable;
        String page = filterAndPageable.filter.remove("page");
        String size = filterAndPageable.filter.remove("size");

        if (StringUtil.isNumeric(page))
            filterAndPageable.pageable = PageRequest.of(Integer.parseInt(page), pageable.getPageSize(), pageable.getSort());
        if (StringUtil.isNumeric(size))
            filterAndPageable.pageable = PageRequest.of(pageable.getPageNumber(), Integer.parseInt(size), pageable.getSort());
    }

    private static PageRequest getDefaultSortingProperty(Pageable pageable) {
        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(RATING_VALUE_SORT));
    }

    @AllArgsConstructor
    private static class FilterAndPageable {
        Map<String, String> filter;
        Pageable pageable;
    }
}
