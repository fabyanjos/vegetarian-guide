package com.fabiale.vegetarianguide.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fabiale.vegetarianguide.model.AddressResult;
import com.fabiale.vegetarianguide.model.MapsResult;
import com.fabiale.vegetarianguide.model.Restaurant;

@Service
public class CoordinateUtil {
	
	@Autowired RestTemplate restTemplate;
	
	private Logger logger = Logger.getLogger(CoordinateUtil.class.getName());
	
	public void distance(Restaurant origin, Restaurant destination) {
		try {
			String url ="http://maps.googleapis.com/maps/api/distancematrix/json?origins={origin}&destinations={destination}&sensor=false";
			
			MapsResult result = restTemplate.getForObject(url, MapsResult.class, origin.getLatLng(), destination.getLatLng());
			
			destination.setDistance(result.getDistance());
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Distance error api: " + e.getMessage(), e);
			throw new RestClientException("Distance error api: " + e.getMessage(), e);
		}
	}
	
	public AddressResult addressDetails(String address) {
		try {
			String url ="http://maps.googleapis.com/maps/api/geocode/json?address={address}&sensor=false";
			
			AddressResult result = restTemplate.getForObject(url, AddressResult.class, address);
			logger.log(Level.INFO, result.toString());
			return result;
		} catch(Exception e) {
			logger.log(Level.SEVERE, "Details error api: " + e.getMessage(), e);
			throw new RestClientException("Details error api: " + e.getMessage(), e);
		}
	}
}
