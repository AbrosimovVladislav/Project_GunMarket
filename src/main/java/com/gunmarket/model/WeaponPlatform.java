package com.gunmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gunmarket.model.product.Product;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static com.gunmarket.model.product.Product.PRODUCT_WEAPON_PLATFORM;

@Entity
@Table(name = "weaponPlatform")
@Component
public class WeaponPlatform {

    public static final String WEAPON_PLATFORM_ID = "weaponPlatform_Id";
    private static final String WEAPON_PLATFORM_NAME = "weaponPlatform_name";
    public static final String WEAPON_PLATFORM_ENTITY = "weaponPlatform";

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = WEAPON_PLATFORM_ID, length = 8, nullable = false)
    private Long weaponPlatform_Id;

    @Column(name = WEAPON_PLATFORM_NAME)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = PRODUCT_WEAPON_PLATFORM)
    private Set<Product> products;

    public WeaponPlatform() {
    }

    public WeaponPlatform(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Long getWeaponPlatform_Id() {
        return weaponPlatform_Id;
    }

    public void setWeaponPlatform_Id(Long weaponPlatform_Id) {
        this.weaponPlatform_Id = weaponPlatform_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "WeaponPlatform{" +
                "weaponPlatform_Id=" + weaponPlatform_Id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
