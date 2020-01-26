package io.gunmarket.demo.marketApp.model.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gunmarket.demo.marketApp.model.domain.BasicEntity;
import io.gunmarket.demo.marketApp.model.domain.offer.ProductInShop;
import io.gunmarket.demo.marketApp.model.domain.attributes.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static io.gunmarket.demo.marketApp.model.domain.attributes.Brand.BRAND_ID;
import static io.gunmarket.demo.marketApp.model.domain.attributes.Caliber.CALIBER_ID;
import static io.gunmarket.demo.marketApp.model.domain.product.Product.PRODUCT_TABLE;
import static io.gunmarket.demo.marketApp.model.domain.attributes.Type.TYPE_ID;
import static io.gunmarket.demo.marketApp.model.domain.attributes.WeaponPlatform.WEAPON_PLATFORM_ID;


@Entity
@Table(name = PRODUCT_TABLE)
@Getter
@Setter
public class Product implements BasicEntity {
    public static final String PRODUCT_TABLE = "product";
    public static final String PRODUCT_MODEL = "model";
    public static final String PRODUCT_ID = "productId";
    public static final String PRODUCT_WEIGHT = "weight";
    public static final String PRODUCT_DTYPE = "dtype";
    public static final String PRODUCT_INFO = "info";
    public static final String PRODUCT_LINK = "link";
    public static final String PRODUCT_IMAGE_LINK = "imageLink";
    public static final String GUN_CAPACITY = "capacity";
    public static final String GUN_TOTAL_LENGTH = "totalLength";
    public static final String GUN_BARREL_LENGTH = "barrelLength";
    public static final String PART_COLOR = "color";
    public static final String PART_PARAMS = "params";
    public static final String PRODUCT_TYPE = "productType";
    public static final String PRODUCT_RATING_ID = "ratingId";
    public static final String PRODUCT_OPERATING_PRINCIPLE = "operatingPrinciple";
    public static final String PRODUCT_CONDITION = "condition";
    public static final String PRODUCT_BARREL_ORIENTATION = "barrelOrientation";
    public static final String PRODUCT_COUNTRY = "country";
    public static final String AMMO_SLEEVE_MATERIAL = "sleeveMaterial";
    public static final String AMMO_CHARGE_TYPE = "chargeType";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PRODUCT_ID, length = 8, nullable = false)
    private Long productId;

    @Column(name = PRODUCT_TYPE, nullable = false, updatable = false)
    private String productType; // allow: GUN, PART, AMMO

    @Column(name = PRODUCT_INFO)
    private String info;

    @Column(name = PRODUCT_LINK)
    private String link;

    @Column(name = PRODUCT_OPERATING_PRINCIPLE)
    @Enumerated(EnumType.STRING)
    private OperatingPrinciple operatingPrinciple;

    @Column(name = PRODUCT_IMAGE_LINK)
    private String imageLink;

    @Column(name = PRODUCT_MODEL)
    private String model;

    @Column(name = PRODUCT_WEIGHT)
    private String weight;

    @Column(name = GUN_CAPACITY)
    private String capacity;

    @Column(name = GUN_TOTAL_LENGTH)
    private String totalLength;

    @Column(name = GUN_BARREL_LENGTH)
    private String barrelLength;

    @Column(name = PART_PARAMS)
    private String params;

    @Column(name = PRODUCT_COUNTRY)
    private String country;

    @Column(name = PART_COLOR)
    private String color;

    @Column(name = PRODUCT_CONDITION)
    private String condition;

    @Column(name = AMMO_SLEEVE_MATERIAL)
    private String sleeveMaterial;

    @Column(name = AMMO_CHARGE_TYPE)
    private String chargeType;

    @Column(name = PRODUCT_BARREL_ORIENTATION)
    private String barrelOrientation;

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

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = PRODUCT_RATING_ID, referencedColumnName = PRODUCT_RATING_ID, unique = true)
    private Rating rating;

    @OneToMany(mappedBy = PRODUCT_TABLE)
    private Set<ProductInShop> productInShop;

    @JsonIgnore
    @OneToMany(mappedBy = PRODUCT_TABLE)
    private Set<Review> review;
}
