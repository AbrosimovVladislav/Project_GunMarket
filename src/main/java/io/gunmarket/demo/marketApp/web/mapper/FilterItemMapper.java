package io.gunmarket.demo.marketApp.web.mapper;

import io.gunmarket.demo.marketApp.model.FilterItem;
import io.gunmarket.demo.marketApp.web.dto.FilterItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilterItemMapper {

    public FilterItemDto map(FilterItem filterItem) {
        return new FilterItemDto()
                .setMenuItemName(filterItem.getMenuItem())
                .setShowName(filterItem.getName())
                .setFilterKey(filterItem.getKeyPath().getValue())
                .setFilterType(filterItem.getType().name())
                .setRank(filterItem.getRank())
                .setValue(filterItem.getValues());
    }

}
