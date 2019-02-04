package com.gunmarket.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gunmarket.model.BasicEntity;
import com.gunmarket.model.Shop;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static com.gunmarket.model.Shop.SHOP_PRODUCTS;

@Entity
@Table(name = "product")
@Component
public class Product implements BasicEntity {

    public static final String PRODUCT_ID = "product_Id";
    private static final String PRODUCT_NAME = "product_name";
    public static final String PRODUCT_PRICE = "product_price";
    public static final String PRODUCT_MANUFACTURER = "product_manufacturer";
    public static final String PRODUCT_CATEGORY = "product_category";
    public static final String PRODUCT_SHOPS = "shops";

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = PRODUCT_ID, length = 8, nullable = false)
    private Long product_Id;

    @Column(name = PRODUCT_NAME)
    private String name;

    @Column(name = PRODUCT_PRICE)
    private String price;

    @Column(name = PRODUCT_MANUFACTURER)
    private String manufacturer;

    @Column(name = PRODUCT_CATEGORY)
    private String category;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = SHOP_PRODUCTS)
    private Set<Shop> shops;

    public Product() {
    }

    public Product(String name, String price, String manufacturer, String category, Set<Shop> shops) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.category = category;
        this.shops = shops;
    }

    public long getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(long product_Id) {
        this.product_Id = product_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_Id=" + product_Id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", category='" + category + '\'' +
                ", shops=" + shops +
                '}';
    }

}
