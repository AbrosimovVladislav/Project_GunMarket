package com.gunmarket.model.product;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Component
public class Gun extends Product {

    public static final String GUN_ENTITY = "Gun";
    public static final String GUN_SUBCATEGORY = "gun_subcategory";

    @Column(name = GUN_SUBCATEGORY)
    private String subcategory;

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
