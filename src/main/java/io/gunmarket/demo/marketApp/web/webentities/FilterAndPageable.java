package io.gunmarket.demo.marketApp.web.webentities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class FilterAndPageable {
	private Map<String, String> filter;
	private Pageable pageable;
}
