package io.gunmarket.demo.marketApp.repo;

import io.gunmarket.demo.marketApp.domain.Review;
import io.gunmarket.demo.marketApp.repo.filterandsorting.FilterAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepo extends JpaRepository<Review, Long>, FilterAndSortingRepository<Review> {
	long countReviewByShopId(long shopId);
}
