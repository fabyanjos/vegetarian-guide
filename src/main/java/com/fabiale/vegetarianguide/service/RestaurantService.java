package com.fabiale.vegetarianguide.service;

import java.util.List;

import javassist.NotFoundException;

import com.fabiale.vegetarianguide.exception.RestaurantNotFoundException;
import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.RestaurantFilter;

public interface RestaurantService {
	
	public List<Restaurant> getAll();

	public Integer create(Restaurant restaurant) throws NotFoundException;
	
	public Restaurant getById(Integer id) throws RestaurantNotFoundException;
	
	public Restaurant getByName(String name) throws RestaurantNotFoundException;
	
	public List<Restaurant> getNearBy(Restaurant restaurant) throws NotFoundException;
	
	public List<Restaurant> getNearBy(RestaurantFilter filter) throws NotFoundException;
	
	public List<Restaurant> getNearBy(Double lat, Double lng) throws NotFoundException;
	
	public List<Restaurant> getLastUptades(int quantity);

}
