package io.gunmarket.demo.marketApp.repo.querybuilder;

import lombok.Builder;
import lombok.ToString;

import java.util.List;


@ToString
@Builder
class QBParam {
	String paramName;
	String paramValue;
	Operation operation;
	List<String> entities;
}