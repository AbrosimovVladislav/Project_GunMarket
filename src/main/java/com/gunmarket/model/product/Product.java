package com.gunmarket.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gunmarket.model.BasicEntity;
import com.gunmarket.model.Caliber;
import com.gunmarket.model.Manufacturer;
import com.gunmarket.model.Shop;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static com.gunmarket.model.Caliber.CALIBER_ID;
import static com.gunmarket.model.Manufacturer.MANUFACTURER_ID;
import static com.gunmarket.model.Shop.SHOP_PRODUCTS;

@Entity
@Table(name = "product")
@Component
public class Product implements BasicEntity {

    public static final String PRODUCT_ID = "product_Id";
    private static final String PRODUCT_NAME = "product_name";
    public static final String PRODUCT_PRICE = "product_price";
    public static final String PRODUCT_MANUFACTURER = "manufacturer";
    public static final String PRODUCT_CATEGORY = "product_category";
    public static final String PRODUCT_CALIBER = "caliber";
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

    @Column(name = PRODUCT_CATEGORY)
    private String category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = CALIBER_ID, nullable = false)
    private Caliber caliber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = MANUFACTURER_ID, nullable = false)
    private Manufacturer manufacturer;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = SHOP_PRODUCTS)
    private Set<Shop> shops;

    public Product() {
    }

    public Product(String name, String price, Manufacturer manufacturer, String category, Caliber caliber, Set<Shop> shops) {
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.category = category;
        this.caliber = caliber;
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Caliber getCaliber() {
        return caliber;
    }

    public void setCaliber(Caliber caliber) {
        this.caliber = caliber;
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
                ", caliber='" + caliber + '\'' +
                ", shops=" + shops +
                '}';
    }

}
