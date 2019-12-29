package io.gunmarket.demo.marketApp.service;

import io.gunmarket.demo.marketApp.domain.Review;
import io.gunmarket.demo.marketApp.repo.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepo reviewRepo;

	public List<Review> getAllByParameters(Map<String, String> requestParams, Pageable pageable) {
		return reviewRepo.findAllByParameters(requestParams, pageable, Review.class);
	}

}
