package com.fabiale.vegetarianguide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository repository;

	public List<Restaurant> getAll() {
		return this.repository.getAll();
	}

	public Integer create(Restaurant restaurant) {
		return this.repository.create(restaurant);
	}
	
	public List<Restaurant> getNearBy(Restaurant restaurant) {
		
		Double latMin = restaurant.getLatitude() - 0.01;
		Double lngMin = restaurant.getLongitude() - 0.01;
		Double latMax = restaurant.getLatitude() + 0.01;
		Double lngMax = restaurant.getLongitude() + 0.01;
		
		return this.repository.getNearBy(latMin, lngMin, latMax, lngMax);
	}
}
