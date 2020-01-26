package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.model.FilterItem;
import io.gunmarket.demo.marketApp.service.FilterItemService;
import io.gunmarket.demo.marketApp.web.dto.FilterItemDto;
import io.gunmarket.demo.marketApp.web.mapper.FilterItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FilterController {

    private final FilterItemService filterItemService;
    private final FilterItemMapper filterItemMapper;

    /*ToDo Выбрать колонку в которой лежат не строки и проверить работоспособность всей цепочки */
    @GetMapping(value = "/product/filters/{menuItem}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<FilterItemDto> getFilterItemsByMenuItem(@PathVariable String menuItem) {
        List<FilterItem> filterItems = filterItemService.getFiltersByMenuItem(menuItem);
        return filterItems.stream().map(filterItemMapper::map).collect(Collectors.toList());
    }

}
