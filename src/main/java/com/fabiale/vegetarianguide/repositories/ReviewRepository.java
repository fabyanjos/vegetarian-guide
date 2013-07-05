package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.Review;

public interface ReviewRepository {
	
	public List<Review> getAll();

	public Integer create(Review review);
    
    public List<Review> getLastUptades(int quantity);
    
    public List<Review> getByRestaurant(Restaurant restaurant);
    
    public Integer getRestaurantRating(Restaurant restaurant);

}
