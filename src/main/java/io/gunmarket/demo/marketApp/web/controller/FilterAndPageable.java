package io.gunmarket.demo.marketApp.web.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
class FilterAndPageable {
	private Map<String, String> filter;
	private Pageable pageable;
}
