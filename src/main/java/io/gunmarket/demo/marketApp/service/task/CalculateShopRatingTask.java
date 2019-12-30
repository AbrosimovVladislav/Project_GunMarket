package io.gunmarket.demo.marketApp.service.task;

import io.gunmarket.demo.marketApp.domain.Review;
import io.gunmarket.demo.marketApp.domain.Shop;
import io.gunmarket.demo.marketApp.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CalculateShopRatingTask implements Runnable {
	private final ShopService shopService;
	private final Shop shop;
	private final Review review;
	private final long reviewsCountBeforeUpdate;

	@Override
	public void run() {
		int userMark = review.getMark();
		double currentRatingBeforeUpdate = shop.getRating().getValue();
		double currentRating = (currentRatingBeforeUpdate * reviewsCountBeforeUpdate + userMark) / (reviewsCountBeforeUpdate + 1);
		shop.getRating().setValue(currentRating);
		shopService.update(shop);
	}
}
