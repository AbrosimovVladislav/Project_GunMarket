package io.gunmarket.demo.marketApp.web.controller;

import io.gunmarket.demo.marketApp.model.domain.attributes.Review;
import io.gunmarket.demo.marketApp.service.ReviewService;
import io.gunmarket.demo.marketApp.web.dto.ReviewDto;
import io.gunmarket.demo.marketApp.web.mapper.ReviewMapper;
import io.gunmarket.demo.marketApp.web.validation.RequestParamsValidator;
import io.gunmarket.demo.marketApp.web.webentities.FilterAndPageable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;
	private final RequestParamsValidator validator;
	private final ReviewMapper reviewMapper;

	private static final int DEFAULT_PAGE_NUMBER = 0;
	private static final int DEFAULT_PAGE_SIZE = 10;

	@GetMapping(value = "/reviews/product/{productId}")
	public List<Review> getAllByProductId(@PathVariable String productId,
	                                   @PageableDefault(size = DEFAULT_PAGE_SIZE, page = DEFAULT_PAGE_NUMBER)
			                                   Pageable pageable) {
		FilterAndPageable pairOfParamsAndPageable =
				validator.validate(Collections.singletonMap("product.productId", productId), pageable, Review.class);
		return reviewService.getAllByParameters(pairOfParamsAndPageable.getFilter(),
				pairOfParamsAndPageable.getPageable()
		);
	}

	@GetMapping(value = "/reviews/shop/{shopId}")
	public List<Review> getAllByShopId(@PathVariable String shopId,
	                                   @PageableDefault(size = DEFAULT_PAGE_SIZE, page = DEFAULT_PAGE_NUMBER)
			                                   Pageable pageable) {
		FilterAndPageable pairOfParamsAndPageable =
				validator.validate(Collections.singletonMap("shop.shopId", shopId), pageable, Review.class);
		return reviewService.getAllByParameters(pairOfParamsAndPageable.getFilter(),
				pairOfParamsAndPageable.getPageable()
		);
	}

	@PostMapping("/reviews/shop")
	public ResponseEntity addReviewOnShop(@RequestBody ReviewDto reviewDto) {
		return ResponseEntity.ok(reviewService.addReviewAndUpdateShopRating(reviewMapper.map(reviewDto)));
	}
}