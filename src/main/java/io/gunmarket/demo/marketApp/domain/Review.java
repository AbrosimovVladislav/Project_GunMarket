package io.gunmarket.demo.marketApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static io.gunmarket.demo.marketApp.domain.Product.PRODUCT_ID;
import static io.gunmarket.demo.marketApp.domain.Review.REVIEW_TABLE;
import static io.gunmarket.demo.marketApp.domain.Shop.SHOP_ID;

@Entity
@Table(name = REVIEW_TABLE)
@Getter
@Setter
public class Review implements BasicEntity {

	public static final String REVIEW_TABLE = "review";
	public static final String REVIEW_ID = "reviewId";
	public static final String REVIEW_MARK = "mark";
	public static final String REVIEW_COMMENT = "comment";
	public static final String REVIEW_PROS = "pros";
	public static final String REVIEW_CONS = "cons";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = REVIEW_ID, length = 8, nullable = false)
	private Long reviewId;

	@Column(name = REVIEW_MARK, nullable = false)
	private int mark;

	@Column(name= REVIEW_PROS)
	private String pros;

	@Column(name= REVIEW_CONS)
	private String cons;

	@Column(name= REVIEW_COMMENT)
	private String comment;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = SHOP_ID)
	private Shop shop;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = PRODUCT_ID)
	private Product product;

	@Column(name = "user_id")
	private Long user;
}
