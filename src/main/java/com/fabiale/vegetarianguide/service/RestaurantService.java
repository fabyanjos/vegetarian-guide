package com.fabiale.vegetarianguide.service;

import java.util.List;

import javassist.NotFoundException;

import com.fabiale.vegetarianguide.exception.RestaurantNotFoundException;
import com.fabiale.vegetarianguide.model.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> getAll();

	public Integer create(Restaurant restaurant) throws NotFoundException;
	
	public Restaurant getById(Integer id) throws RestaurantNotFoundException;
	
	public List<Restaurant> getNearBy(Restaurant restaurant) throws NotFoundException;
	
	public List<Restaurant> getLastUptades(int quantity);

}
