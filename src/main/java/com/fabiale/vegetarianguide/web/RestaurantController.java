package com.fabiale.vegetarianguide.web;

import java.util.List;

import javassist.NotFoundException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fabiale.vegetarianguide.model.Country;
import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.service.CountryService;
import com.fabiale.vegetarianguide.service.RestaurantService;

@Controller
public class RestaurantController {
	
	@Autowired RestaurantService service;
	@Autowired CountryService countryService;

	@RequestMapping(value = "/restaurant/new", method = RequestMethod.GET)
	public String home() {
		return "/restaurant/add";
	}
	
	@RequestMapping(value = "/restaurant/add", method = {RequestMethod.POST, RequestMethod.GET})
	public String save(@ModelAttribute("restaurant") @Valid Restaurant restaurant, BindingResult result, ModelMap modelMap) {
		
		if (result.hasErrors()) {
			modelMap.addAttribute("error", "error");
		} else {
			Country country = countryService.findByName(restaurant.getCountry().getName());
			if(country == null || country.getId() == null)
				countryService.create(restaurant.getCountry());
			else
				restaurant.setCountry(country);
			
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	        HttpSession session = attr.getRequest().getSession();
			User user = (User) session.getAttribute("user");
			restaurant.setCreatedBy(user);
			service.create(restaurant);
		}
		return "/restaurant/add";
	}
	
	@RequestMapping(value = "/restaurant/search", method = RequestMethod.GET)
	public String search() {
		return "/restaurant/search";
	}
	
	@RequestMapping(value = "/restaurant/results", method = {RequestMethod.POST, RequestMethod.GET})
	public String result(@ModelAttribute("restaurant") Restaurant restaurant, ModelMap modelMap) {
		
		List<Restaurant> list = service.getNearBy(restaurant);
		for(Restaurant r : list)
			System.out.println(r.toString());
		
		modelMap.addAttribute("restaurants", list);
		modelMap.addAttribute("origin", restaurant);
		return "/restaurant/search";
	}
	
    @RequestMapping(value = "/restaurant/details/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String getDetails(@PathVariable("id") Integer id, ModelMap modelMap) throws NotFoundException {
		Restaurant restaurant = service.getById(id);
		modelMap.addAttribute("restaurant", restaurant);
        return "/restaurant/details";
    }
	
	@ModelAttribute("restaurant")
    public Restaurant createForm() {
        return new Restaurant();
    }
}
