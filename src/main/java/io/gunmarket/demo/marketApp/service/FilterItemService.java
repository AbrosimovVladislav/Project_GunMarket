package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.model.FilterItem;
import io.gunmarket.demo.marketApp.model.KeyPath;
import io.gunmarket.demo.marketApp.repo.FilterItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilterItemService {

    private final FilterItemRepo filterItemRepo;

    public List<FilterItem> getFiltersByMenuItem(String menuItem) {
        List<FilterItem> filterItems = filterItemRepo.findAllByMenuItem(menuItem);
        filterItems.forEach(this::determineValues);
        return filterItems;
    }

    private void determineValues(FilterItem filterItem) {
        KeyPath keyPath = filterItem.getKeyPath();
        List<String> values = filterItemRepo.selectFrom(keyPath.getTargetParam(), keyPath.getTargetEntity());
        filterItem.setValues(values);
    }
}
