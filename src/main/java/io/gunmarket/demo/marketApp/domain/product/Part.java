package io.gunmarket.demo.marketApp.domain.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Part extends Product {
	public static final String PART_COLOR = "color";
	public static final String PART_PARAMS = "params";

	@Column(name = PART_PARAMS)
	private String params;

	@Column(name = PART_COLOR)
	private String color;
}
