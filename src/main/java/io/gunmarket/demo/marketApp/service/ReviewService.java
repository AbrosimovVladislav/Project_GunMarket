package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.model.domain.attributes.Review;
import io.gunmarket.demo.marketApp.model.domain.shop.Shop;
import io.gunmarket.demo.marketApp.repo.ReviewRepo;
import io.gunmarket.demo.marketApp.service.task.CalculateShopRatingTask;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReviewService {
	private final ReviewRepo reviewRepo;
	private final ShopService shopService;

	public List<Review> getAllByParameters(Map<String, String> requestParams, Pageable pageable) {
		return reviewRepo.findAllByParameters(requestParams, pageable, Review.class);
	}

	@Transactional
	public boolean addReviewAndUpdateShopRating(Review review) {
		Shop shop = review.getShop();
		long reviewsCountBeforeUpdate = reviewRepo.countReviewByShop(shop);
		new CalculateShopRatingTask(shopService, shop, review, reviewsCountBeforeUpdate).run();
		reviewRepo.save(review);
		return true;
	}
}
