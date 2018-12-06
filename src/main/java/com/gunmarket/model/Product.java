package com.gunmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static com.gunmarket.model.Shop.SHOP_PRODUCTS;
import static com.gunmarket.model.Type.TYPE_ID;

@Entity
@Table(name = "product")
@Component
public class Product {

    public static final String PRODUCT_ID = "product_Id";
    public static final String PRODUCT_NAME = "name";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_TYPE = "type";
    public static final String PRODUCT_SHOPS = "shops";

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = PRODUCT_ID, length = 8, nullable = false)
    private long product_Id;

    @Column(name = PRODUCT_NAME)
    private String name;

    @Column(name = PRODUCT_PRICE)
    private String price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = TYPE_ID, nullable = false)
    private Type type;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = SHOP_PRODUCTS)
    private Set<Shop> shops;

    public Product() {
    }

    public Product(String name, String price, Type type, Set<Shop> shops) {
        this.name = name;
        this.price = price;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
                ", type=" + type +
                ", shops=" + shops +
                '}';
    }

}
