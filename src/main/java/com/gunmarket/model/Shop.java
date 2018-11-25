package com.gunmarket.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static com.gunmarket.model.Product.PRODUCT_ID;

@Entity
@Table(name = "shop")
@Component
public class Shop {

    public static final String SHOP_ID = "shop_Id";
    public static final String SHOP_NAME = "name";
    public static final String SHOP_ADDRESS = "address";
    public static final String SHOP_WEBSITE = "website";
    public static final String SHOP_PRODUCTS = "products";
    public static final String SHOPPRODUCT_TABLE = "shop_product";

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = SHOP_ID, length = 8, nullable = false)
    private long shop_Id;

    @Column(name = SHOP_NAME)
    private String name;

    @Column(name = SHOP_ADDRESS)
    private String address;

    @Column(name = SHOP_WEBSITE)
    private String website;

    @ManyToMany
    @JoinTable(name = SHOPPRODUCT_TABLE,
            joinColumns = @JoinColumn(name = SHOP_ID, referencedColumnName = SHOP_ID),
            inverseJoinColumns = @JoinColumn(name = PRODUCT_ID, referencedColumnName = PRODUCT_ID))
    private Set<Product> products;

    public Shop() {
    }

    public Shop(String name, String address, String website, Set<Product> products) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.products = products;
    }

    public long getShop_Id() {
        return shop_Id;
    }

    public void setShop_Id(long shop_Id) {
        this.shop_Id = shop_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_Id=" + shop_Id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", products=" + products +
                '}';
    }

}
