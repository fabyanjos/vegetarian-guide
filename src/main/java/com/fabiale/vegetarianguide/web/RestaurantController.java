package com.fabiale.vegetarianguide.web;

import java.util.List;

import javassist.NotFoundException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dropbox.client2.exception.DropboxException;
import com.fabiale.vegetarianguide.model.Image;
import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.Review;
import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.service.CountryService;
import com.fabiale.vegetarianguide.service.ImageService;
import com.fabiale.vegetarianguide.service.RestaurantService;
import com.fabiale.vegetarianguide.service.ReviewService;

@Controller
public class RestaurantController {
	
	@Autowired RestaurantService service;
	@Autowired CountryService countryService;
	@Autowired ReviewService reviewService;
	@Autowired ImageService imageService;

	@Secured("ROLE_USER")
	@RequestMapping(value = "/restaurant/new", method = RequestMethod.GET)
	public String home(ModelMap map) {
		map.addAttribute("current", "add");
		return "/restaurant/add";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/restaurant/add", method = {RequestMethod.POST, RequestMethod.GET})
	public String save(@ModelAttribute("restaurant") @Valid Restaurant restaurant, BindingResult result, ModelMap modelMap) {
		
		if (result.hasErrors()) {
			modelMap.addAttribute("error", "error.add.validation.restaurant");
			return "/restaurant/add";
		} else {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			restaurant.setCreatedBy(user);
			service.create(restaurant);
			modelMap.addAttribute("success", "success.save.restaurant");
			return "/success";
		}
	}
	
	@RequestMapping(value = "/restaurant/search", method = RequestMethod.GET)
	public String search(ModelMap map) {
		map.addAttribute("current", "search");
		return "/restaurant/search";
	}
	
	@RequestMapping(value = "/restaurant/results", method = {RequestMethod.POST, RequestMethod.GET})
	public String result(@ModelAttribute("restaurant") Restaurant restaurant, ModelMap modelMap) {

		List<Restaurant> list = service.getNearBy(restaurant);

		modelMap.addAttribute("restaurants", list);
		modelMap.addAttribute("origin", restaurant);
		return "/restaurant/search";
	}
	
    @RequestMapping(value = "/restaurant/details/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String getDetails(@PathVariable("id") Integer id, ModelMap modelMap) throws NotFoundException, DropboxException {
		Restaurant restaurant = service.getById(id);
		List<Review> reviews = reviewService.getByRestaurant(restaurant);
		List<Image> images = imageService.getByRestaurant(restaurant);
		modelMap.addAttribute("restaurant", restaurant);
		modelMap.addAttribute("reviews", reviews);
		modelMap.addAttribute("images", images);
        return "/restaurant/details";
    }
    
    @RequestMapping(value = "/restaurant/list/{qtd}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<Restaurant> getLastUpdates(@PathVariable("qtd") int qtd) {
		return service.getLastUptades(qtd);
	}
	
	@ModelAttribute("restaurant")
    public Restaurant createForm() {
        return new Restaurant();
    }
}
