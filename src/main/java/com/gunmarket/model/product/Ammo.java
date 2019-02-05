package com.gunmarket.model.product;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Component
public class Ammo extends Product {

    public static final String AMMO_ENTITY = "Ammo";

}
