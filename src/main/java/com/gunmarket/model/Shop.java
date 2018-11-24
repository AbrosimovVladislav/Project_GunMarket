package com.gunmarket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shop")
@Component
public class Shop {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "shop_Id", length = 8, nullable = false)
    private long shop_Id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "shop_product",
            joinColumns = @JoinColumn(name = "shop_Id", referencedColumnName = "shop_Id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"))
    private Set<Product> products;

    public Shop() {
    }

    public Shop(String name, Set<Product> products) {
        this.name = name;
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
                ", products=" + products +
                '}';
    }

}
