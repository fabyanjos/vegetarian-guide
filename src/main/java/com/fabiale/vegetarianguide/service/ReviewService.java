package com.fabiale.vegetarianguide.service;

import java.util.List;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.Review;

public interface ReviewService {
	
	public List<Review> getAll();

	public Integer create(Review review);
	
	public List<Review> getLastUptades(int quantity);
	
	public List<Review> getByRestaurant(Restaurant restaurant);

}
