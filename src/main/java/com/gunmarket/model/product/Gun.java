package com.gunmarket.model.product;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gun")
@Component
public class Gun extends Product {

    public static final String GUN_ENTITY = "Gun";
    public static final String GUN_CALIBER = "gun_caliber";
    public static final String GUN_FAMILY = "gun_family";
    public static final String GUN_SUBCATEGORY = "gun_subcategory";

    @Column(name = GUN_CALIBER)
    private String caliber;

    @Column(name = GUN_FAMILY)
    private String family;

    @Column(name = GUN_SUBCATEGORY)
    private String subcategory;

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
}
