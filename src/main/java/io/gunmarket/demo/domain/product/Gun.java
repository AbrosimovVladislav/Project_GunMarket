package io.gunmarket.demo.domain.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Getter
@Setter
public class Gun extends Product {
	public static final String GUN_CAPACITY = "capacity";
	public static final String GUN_TOTAL_LENGTH = "totalLength";
	public static final String GUN_BARREL_LENGTH = "barrelLength";
	public static final String GUN_WEIGHT = "weight";

	@Column(name = GUN_CAPACITY)
	private String capacity;

	@Column(name = GUN_TOTAL_LENGTH)
	private String totalLength;

	@Column(name = GUN_BARREL_LENGTH)
	private String barrelLength;

	@Column(name = GUN_WEIGHT)
	private String weight;
}
