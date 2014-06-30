package com.fabiale.vegetarianguide.service.impl;

import java.util.Collections;
import java.util.List;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.exception.RestaurantNotFoundException;
import com.fabiale.vegetarianguide.model.AddressResult;
import com.fabiale.vegetarianguide.model.Country;
import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.repositories.RestaurantRepository;
import com.fabiale.vegetarianguide.repositories.ReviewRepository;
import com.fabiale.vegetarianguide.service.CountryService;
import com.fabiale.vegetarianguide.service.RestaurantService;
import com.fabiale.vegetarianguide.util.CoordinateUtil;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired private RestaurantRepository repository;
	@Autowired private ReviewRepository reviewRepository;
	@Autowired private CoordinateUtil coordinate;
	@Autowired private CountryService countryService;
	
	public List<Restaurant> getAll() {
		return this.repository.getAll();
	}

	public Integer create(Restaurant restaurant) throws NotFoundException {
		AddressResult details = coordinate.addressDetails(restaurant.getAddress());
		details.populate(restaurant);
		
		Country country = countryService.findByName(restaurant.getCountry().getName());
		if(country == null || country.getId() == null)
			countryService.create(restaurant.getCountry());
		else
			restaurant.setCountry(country);
		
		return this.repository.create(restaurant);
	}
	
	public Restaurant getById(Integer id) throws RestaurantNotFoundException {
		Restaurant r = this.repository.getById(id);
		if (r != null) {
			r.setRating(reviewRepository.getRestaurantRating(r));
			return r;
		}
		throw new RestaurantNotFoundException("Not Found");
	}
	
	public List<Restaurant> getNearBy(Restaurant restaurant) throws NotFoundException {
		List<Restaurant> result = null;
		AddressResult ar = coordinate.addressDetails(restaurant.getAddress());  
		if(ar != null && ar.getStatus() != null && ar.getStatus().equals("OK") && ar.getResults() != null) {
			ar.populate(restaurant);
			result = this.getNearBy(restaurant.getLatitude(), restaurant.getLongitude());
		}
		return result;
	}
	
	public List<Restaurant> getLastUptades(int quantity) {
		return repository.getLastUptades(quantity);
	}

	@Override
	public List<Restaurant> getNearBy(Double lat, Double lng) throws NotFoundException {
		
		Double dist = 0.05;

		Double latMin = lat - dist;
		Double lngMin = lng - dist;
		Double latMax = lat + dist;
		Double lngMax = lng + dist;
		
		List<Restaurant> result = this.repository.getNearBy(latMin, lngMin, latMax, lngMax);
		for(Restaurant r : result) {
			coordinate.distance(lat, lng, r);
			r.setRating(reviewRepository.getRestaurantRating(r));
		}
		
		Collections.sort(result);
		return result;
	}

	@Override
	public Restaurant getByName(String name) throws RestaurantNotFoundException {
		Restaurant r = this.repository.getByName(name.replaceAll("-", " "));
		if (r != null) {
			r.setRating(reviewRepository.getRestaurantRating(r));
			return r;
		}
		throw new RestaurantNotFoundException("Not Found");
	}
}