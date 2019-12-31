package io.gunmarket.demo.marketApp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static io.gunmarket.demo.marketApp.domain.Rating.RATING_TABLE;


@Entity
@Table(name = RATING_TABLE)
@Getter
@Setter
@Accessors(chain = true)
public class Rating {
    public static final String RATING_TABLE = "rating";
    public static final String RATING_ID = "ratingId";
    public static final String RATING_VALUE_SORT = "rating.value";
    public static final String RATING_PRODUCT = "product";
    private static final String RATING_PRODUCT_ID = "productId";
    private static final String RATING_VALUE = "value";
    private static final String RATING_SHOP_ID = "shopId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = RATING_ID, length = 8, nullable = false)
    private Long ratingId;

    @Min(0)
    @Max(5)
    @Column(name = RATING_VALUE)
    private double value;

    @OneToOne(mappedBy = RATING_TABLE)
    private Product product;

    @OneToOne(mappedBy = RATING_TABLE)
    private Shop shop;
}
