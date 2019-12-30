package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.Review;
import io.gunmarket.demo.marketApp.domain.Shop;
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
		reviewRepo.save(review);
		Shop shop = review.getShop();
		long reviewsCountBeforeUpdate = reviewRepo.countReviewByShopId(shop.getShopId());
		new CalculateShopRatingTask(shopService, shop, review, reviewsCountBeforeUpdate).run();
		return true;
	}
}
