package io.gunmarket.demo.domain.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Getter
@Setter
public class Ammo extends Product {
	public static final String AMMO_WEIGHT = "weight";

	@Column(name = AMMO_WEIGHT)
	private String weight;
}
