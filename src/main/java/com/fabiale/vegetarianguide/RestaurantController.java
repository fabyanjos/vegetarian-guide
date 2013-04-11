package com.fabiale.vegetarianguide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fabiale.vegetarianguide.model.Country;
import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.service.CountryService;
import com.fabiale.vegetarianguide.service.RestaurantService;

@Controller
public class RestaurantController {
	
	@Autowired RestaurantService service;
	@Autowired CountryService countryService;

	@RequestMapping(value = "/restaurant", method = RequestMethod.GET)
	public String home() {
		return "/restaurant";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search() {
		return "/search";
	}
	
	@RequestMapping(value = "/restaurant/search", method = RequestMethod.POST)
	public String result(@ModelAttribute("restaurant") Restaurant restaurant, BindingResult result) {
		List<Restaurant> list = service.getNearBy(restaurant);
		for(Restaurant r : list)
			System.out.println(r.toString());
		return "/results";
	}
	
	@RequestMapping(value = "/restaurant/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("restaurant") Restaurant restaurant, BindingResult result) {
		
		Country country = countryService.findByName(restaurant.getCountry().getName());
		if(country == null || country.getId() == null)
			countryService.create(restaurant.getCountry());
		else
			restaurant.setCountry(country);
		
		System.out.println(restaurant.toString());
		
		service.create(restaurant);
		
		return "/restaurant";
	}
	
	@ModelAttribute("restaurant")
    public Restaurant createForm() {
        return new Restaurant();
    }
}
