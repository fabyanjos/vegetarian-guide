package com.fabiale.vegetarianguide.web;

import java.util.List;

import javassist.NotFoundException;

import javax.servlet.http.HttpSession;
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
import com.fabiale.vegetarianguide.exception.RestaurantNotFoundException;
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
	public String home(HttpSession session) {
		session.setAttribute("current", "add");
		return "/restaurant/add";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/restaurant/add", method = {RequestMethod.POST, RequestMethod.GET})
	public String save(@ModelAttribute("restaurant") @Valid Restaurant restaurant, BindingResult result, ModelMap modelMap) throws NotFoundException {
		
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
	public String search(HttpSession session) {
		session.setAttribute("current", "search");
		return "/restaurant/search";
	}
	
	@RequestMapping(value = "/restaurant/results", method = {RequestMethod.POST, RequestMethod.GET})
	public String result(@ModelAttribute("restaurant") Restaurant restaurant, ModelMap modelMap) throws NotFoundException {

		List<Restaurant> list = service.getNearBy(restaurant);

		modelMap.addAttribute("restaurants", list);
		modelMap.addAttribute("origin", restaurant);
		return "/restaurant/search";
	}
	
	@RequestMapping(value = "/rest/restaurant/search/{lat}/{lng}", produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
    public List<Restaurant> restSearch(@PathVariable("lat") String lat, @PathVariable("lng") String lng, ModelMap modelMap) throws NotFoundException, DropboxException, RestaurantNotFoundException {
		
		List<Restaurant> result = service.getNearBy(Double.valueOf(lat), Double.valueOf(lng));

        return result;
    }
	
    @RequestMapping(value = "/restaurant/details/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public String getDetails(@PathVariable("id") Integer id, ModelMap modelMap) throws NotFoundException, DropboxException, RestaurantNotFoundException {
		Restaurant restaurant = service.getById(id);
		List<Review> reviews = reviewService.getByRestaurant(restaurant);
		List<Image> images = imageService.getByRestaurant(restaurant);
		modelMap.addAttribute("restaurant", restaurant);
		modelMap.addAttribute("reviews", reviews);
		modelMap.addAttribute("images", images);
        return "/restaurant/details";
    }
    
    @RequestMapping(value = "/restaurant/{name}", method = {RequestMethod.POST, RequestMethod.GET})
    public String getDetailsByName(@PathVariable("name") String name, ModelMap modelMap) throws NotFoundException, DropboxException, RestaurantNotFoundException {
		Restaurant restaurant = service.getByName(name);
		List<Review> reviews = reviewService.getByRestaurant(restaurant);
		List<Image> images = imageService.getByRestaurant(restaurant);
		modelMap.addAttribute("restaurant", restaurant);
		modelMap.addAttribute("reviews", reviews);
		modelMap.addAttribute("images", images);
        return "/restaurant/details";
    }
    
    @RequestMapping(value = "/restaurant/list/{qtd}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<Restaurant> getLastUpdates(@PathVariable("qtd") int qtd) throws DropboxException {
		List<Restaurant> lastUptades = service.getLastUptades(qtd);
		for (Restaurant restaurant : lastUptades) {
			List<Image> images = imageService.getByRestaurant(restaurant, 1);
			if(images!= null && !images.isEmpty())
				restaurant.setImageUrl(images.iterator().next().getFilePath());
		}
		return lastUptades;
	}
	
	@ModelAttribute("restaurant")
    public Restaurant createForm() {
        return new Restaurant();
    }
}
