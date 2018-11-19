package com.gunmarket.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "product_Id", length = 8, nullable = false)
    private long product_Id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
    private Set<Product> shops;

    public Product() {
    }

    public Product(String name, Set<Product> shops) {
        this.name = name;
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

    public Set<Product> getShops() {
        return shops;
    }

    public void setShops(Set<Product> shops) {
        this.shops = shops;
    }
}
