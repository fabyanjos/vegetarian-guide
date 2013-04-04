package com.fabiale.vegetarianguide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value = "/restaurant/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("restaurant") Restaurant restaurant, BindingResult result) {
		
		System.out.println(restaurant.toString());
		
		restaurant.setCountry(countryService.findByName(restaurant.getCountry().getName()));
		
		service.create(restaurant);
		
		return "/restaurant";
	}
	
	@ModelAttribute("restaurant")
    public Restaurant createForm() {
        return new Restaurant();
    }
}
