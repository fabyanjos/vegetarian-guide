package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import com.fabiale.vegetarianguide.model.Restaurant;

public interface RestaurantRepository {
	
	public List<Restaurant> getAll();

	public Integer create(Restaurant restaurant);
    
    public Restaurant getById(Integer id);
    
    public List<Restaurant> getNearBy(Double latMin, Double lngMin, Double latMax, Double lngMax);
    
    public List<Restaurant> getLastUptades(int quantity);

}
