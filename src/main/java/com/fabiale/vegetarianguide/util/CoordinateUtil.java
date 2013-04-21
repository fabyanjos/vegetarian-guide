package com.fabiale.vegetarianguide.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fabiale.vegetarianguide.model.MapsResult;
import com.fabiale.vegetarianguide.model.Restaurant;

@Service
public class CoordinateUtil {
	
	@Autowired RestTemplate restTemplate;
	
	public void distance(Restaurant origin, Restaurant destination) {
		String url ="http://maps.googleapis.com/maps/api/distancematrix/json?origins={origin}&destinations={destination}&sensor=false";
		
		MapsResult r = restTemplate.getForObject(url, MapsResult.class, origin.getLatLng(), destination.getLatLng());
		
		destination.setDistance(r.getDistance());
	}
}
