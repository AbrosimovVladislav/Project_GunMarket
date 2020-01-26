package io.gunmarket.demo.marketApp.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class FilterItemDto {

    private String menuItemName;
    private String showName;
    private String filterKey;
    private String filterType;
    private int rank;

}
