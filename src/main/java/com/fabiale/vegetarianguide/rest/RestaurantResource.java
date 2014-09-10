package com.fabiale.vegetarianguide.rest;

import java.util.List;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.service.RestaurantService;

@Controller
@RequestMapping("/api/restaurant")
public class RestaurantResource {
	
	@Autowired RestaurantService service;
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurant> index() {

		List<Restaurant> list = service.getAll();
		return list;
	}
    
    @ResponseBody
    @RequestMapping(value = "/{lat}/{lng:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurant> search(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng) throws NotFoundException {

    	List<Restaurant> list = service.getNearBy(lat, lng);
		return list;
	}	
}
