package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.RestaurantFilter;

public interface RestaurantRepository {
	
	public List<Restaurant> getAll();

	public Integer create(Restaurant restaurant);
    
    public Restaurant getById(Integer id);
    
    public Restaurant getByName(String name);
    
    public List<Restaurant> getNearBy(Double latMin, Double lngMin, Double latMax, Double lngMax);
    
    public List<Restaurant> getNearBy(Double latMin, Double lngMin, Double latMax, Double lngMax, RestaurantFilter filter);
    
    public List<Restaurant> getLastUptades(int quantity);

}
