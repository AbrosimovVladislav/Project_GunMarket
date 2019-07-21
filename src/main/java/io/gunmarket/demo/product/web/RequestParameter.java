package io.gunmarket.demo.product.web;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class RequestParameter {
	private static final String idPostfix = "_id";
	private final String name;
	private final String value;

	public RequestParameter(String name, String value, boolean isId) {
		if (isId) {
			this.name = name + idPostfix;
			this.value = value;
		} else {
			this.name = name;
			this.value = "'" + value.replaceAll(",", "','") + "'";
		}
	}
}
