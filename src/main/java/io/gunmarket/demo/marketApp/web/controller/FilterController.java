package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.model.FilterItem;
import io.gunmarket.demo.marketApp.service.FilterItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FilterController {

    private final FilterItemService filterItemService;

    @GetMapping(value = "/product/filters/{menuItem}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<FilterItem> getFilterItemsByMenuItem(@PathVariable String menuItem) {
        return filterItemService.getFiltersByMenuItem(menuItem);
    }

}
