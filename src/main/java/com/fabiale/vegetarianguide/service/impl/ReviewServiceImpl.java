package com.fabiale.vegetarianguide.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.Review;
import com.fabiale.vegetarianguide.repositories.ReviewRepository;
import com.fabiale.vegetarianguide.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository repository;

	public List<Review> getAll() {
		return this.repository.getAll();
	}

	public Integer create(Review review) {
		return this.repository.create(review);
	}
	
	public List<Review> getLastUptades(int quantity) {
		return repository.getLastUptades(quantity);
	}
	
	public List<Review> getByRestaurant(Restaurant restaurant) {
		return repository.getByRestaurant(restaurant);
	}
}
