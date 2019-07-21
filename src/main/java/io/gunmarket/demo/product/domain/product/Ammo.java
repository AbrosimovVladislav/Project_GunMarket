package io.gunmarket.demo.product.domain.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Ammo extends Product {}
