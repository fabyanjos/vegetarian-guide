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
		
		Double dist = 0.05;
		
		Double latMin = restaurant.getLatitude() - dist;
		Double lngMin = restaurant.getLongitude() - dist;
		Double latMax = restaurant.getLatitude() + dist;
		Double lngMax = restaurant.getLongitude() + dist;
		
		return this.repository.getNearBy(latMin, lngMin, latMax, lngMax);
	}
}
