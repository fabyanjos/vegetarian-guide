package com.fabiale.vegetarianguide.service;

import java.util.List;

import com.fabiale.vegetarianguide.exception.RestaurantNotFoundException;
import com.fabiale.vegetarianguide.model.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> getAll();

	public Integer create(Restaurant restaurant);
	
	public Restaurant getById(Integer id) throws RestaurantNotFoundException;
	
	public List<Restaurant> getNearBy(Restaurant restaurant);
	
	public List<Restaurant> getLastUptades(int quantity);

}
