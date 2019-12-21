package io.gunmarket.demo.marketApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.gunmarket.demo.marketApp.domain.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static io.gunmarket.demo.marketApp.domain.Rating.RATING_TABLE;
import static io.gunmarket.demo.marketApp.domain.product.Product.PRODUCT_ID;

@Entity
@Table(name = RATING_TABLE)
@Getter
@Setter
public class Rating {

    public static final String RATING_TABLE = "rating";
    public static final String RATING_ID = "ratingId";
    private static final String RATING_VALUE = "value";
    public static final String RATING_PRODUCT = "product";
    private static final String RATING_PRODUCT_ID = "product_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = RATING_ID, length = 8, nullable = false)
    private Long ratingId;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = RATING_PRODUCT_ID, referencedColumnName = PRODUCT_ID)
    private Product product;

    @Column(name = RATING_VALUE)
    private String value;

}
