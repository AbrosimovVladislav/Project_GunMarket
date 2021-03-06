package io.gunmarket.demo.marketApp.domain.product;

import io.gunmarket.demo.marketApp.domain.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static io.gunmarket.demo.marketApp.domain.Brand.BRAND_ID;
import static io.gunmarket.demo.marketApp.domain.Caliber.CALIBER_ID;
import static io.gunmarket.demo.marketApp.domain.Rating.RATING_PRODUCT;
import static io.gunmarket.demo.marketApp.domain.Type.TYPE_ID;
import static io.gunmarket.demo.marketApp.domain.WeaponPlatform.WEAPON_PLATFORM_ID;
import static io.gunmarket.demo.marketApp.domain.product.Product.PRODUCT_TABLE;


@Entity
@Table(name = PRODUCT_TABLE)
@Getter
@Setter
public abstract class Product implements BasicEntity {
    public static final String PRODUCT_TABLE = "product";
    public static final String PRODUCT_AVG_PRICE = "averagePrice";
    public static final String PRODUCT_MODEL = "model";
    public static final String PRODUCT_ID = "productId";
    public static final String PRODUCT_WEIGHT = "weight";
    public static final String PRODUCT_DTYPE = "dtype";
    public static final String PRODUCT_INFO = "info";
    public static final String PRODUCT_LINK = "link";
    public static final String PRODUCT_IMAGE_LINK = "imageLink";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PRODUCT_ID, length = 8, nullable = false)
    private Long productId;

    @Column(name = PRODUCT_INFO)
    private String info;

    @Column(name = PRODUCT_LINK)
    private String link;

    @Column(name = PRODUCT_IMAGE_LINK)
    private String imageLink;

    @Column(name = PRODUCT_AVG_PRICE)
    private double averagePrice;

    @Column(name = PRODUCT_MODEL)
    private String model;

    @Column(name = PRODUCT_WEIGHT)
    private String weight;

    @ManyToOne
    @JoinColumn(name = BRAND_ID, nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = TYPE_ID, nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name = CALIBER_ID)
    private Caliber caliber;

    @ManyToOne
    @JoinColumn(name = WEAPON_PLATFORM_ID)
    private WeaponPlatform weaponPlatform;

    @OneToOne(mappedBy = RATING_PRODUCT)
    private Rating rating;

    @OneToMany(mappedBy = PRODUCT_TABLE)
    private Set<ProductInShop> productInShop;
}
