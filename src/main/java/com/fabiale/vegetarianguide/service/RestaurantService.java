package com.fabiale.vegetarianguide.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.model.AddressResult;
import com.fabiale.vegetarianguide.model.Country;
import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.repositories.RestaurantRepository;
import com.fabiale.vegetarianguide.repositories.ReviewRepository;
import com.fabiale.vegetarianguide.util.CoordinateUtil;

@Service
public class RestaurantService {
	
	@Autowired private RestaurantRepository repository;
	@Autowired private ReviewRepository reviewRepository;
	@Autowired private CoordinateUtil coordinate;
	@Autowired private CountryService countryService;
	

	public List<Restaurant> getAll() {
		return this.repository.getAll();
	}

	public Integer create(Restaurant restaurant) {
		AddressResult details = coordinate.addressDetails(restaurant.getAddress());
		details.populate(restaurant);
		
		Country country = countryService.findByName(restaurant.getCountry().getName());
		if(country == null || country.getId() == null)
			countryService.create(restaurant.getCountry());
		else
			restaurant.setCountry(country);
		
		return this.repository.create(restaurant);
	}
	
	public Restaurant getById(Integer id) {
		Restaurant r = this.repository.getById(id);
		r.setRating(reviewRepository.getRestaurantRating(r));
		return r;
	}
	
	public List<Restaurant> getNearBy(Restaurant restaurant) {
		List<Restaurant> result = null;
		AddressResult ar = coordinate.addressDetails(restaurant.getAddress());  
		if(ar != null && ar.getStatus() != null && ar.getStatus().equals("OK") && ar.getResults() != null) {
			ar.populate(restaurant);
			Double dist = 0.05;
			
			Double latMin = restaurant.getLatitude() - dist;
			Double lngMin = restaurant.getLongitude() - dist;
			Double latMax = restaurant.getLatitude() + dist;
			Double lngMax = restaurant.getLongitude() + dist;
			
			result = this.repository.getNearBy(latMin, lngMin, latMax, lngMax);
			
			for(Restaurant r : result) {
				coordinate.distance(restaurant, r);
				r.setRating(reviewRepository.getRestaurantRating(r));
			}
			
			Collections.sort(result);
		}
		return result;
	}
	
	public List<Restaurant> getLastUptades(int quantity) {
		return repository.getLastUptades(quantity);
	}
}