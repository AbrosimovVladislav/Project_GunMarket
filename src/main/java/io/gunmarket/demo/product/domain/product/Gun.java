package io.gunmarket.demo.product.domain.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Gun extends Product {
	public static final String GUN_CAPACITY = "capacity";
	public static final String GUN_TOTAL_LENGTH = "totalLength";
	public static final String GUN_BARREL_LENGTH = "barrelLength";

	@Column(name = GUN_CAPACITY)
	private String capacity;

	@Column(name = GUN_TOTAL_LENGTH)
	private String totalLength;

	@Column(name = GUN_BARREL_LENGTH)
	private String barrelLength;
}
