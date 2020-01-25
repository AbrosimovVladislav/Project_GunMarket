package io.gunmarket.demo.marketApp.repo;

import filterandsorting.FilterAndSortingRepository;
import io.gunmarket.demo.marketApp.model.domain.Shop;
import io.gunmarket.demo.marketApp.model.domain.attributes.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepo extends JpaRepository<Review, Long>, FilterAndSortingRepository<Review> {
    long countReviewByShop(Shop shop);
}
