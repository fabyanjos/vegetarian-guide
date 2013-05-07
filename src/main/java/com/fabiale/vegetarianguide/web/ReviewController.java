package com.fabiale.vegetarianguide.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.Review;
import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.service.RestaurantService;
import com.fabiale.vegetarianguide.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired ReviewService reviewService;
	@Autowired RestaurantService restaurantService;
	
	@RequestMapping(value = "/restaurant/review/{id}", method = RequestMethod.GET)
	public String review(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("restaurantId", id);
		return "/restaurant/review";
	}
	
	@RequestMapping(value = "/restaurant/review/save/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String save(@PathVariable("id") Integer id, @ModelAttribute("review") @Valid Review review, BindingResult result, ModelMap modelMap) {
		
		if (result.hasErrors()) {
			modelMap.addAttribute("restaurantId", id);
			modelMap.addAttribute("error", "error");
		} else {
			Restaurant restaurant = restaurantService.getById(id);
			review.setRestaurant(restaurant);
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	        HttpSession session = attr.getRequest().getSession();
			User user = (User) session.getAttribute("user");
			review.setUser(user);
			reviewService.create(review);
			return "redirect:/restaurant/details/" + id;
		}
		return "/restaurant/review";
	}
	
	@RequestMapping(value = "/restaurant/review/list/{qtd}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<Review> getLastUpdates(@PathVariable("qtd") int qtd) {
		return reviewService.getLastUptades(qtd);
	}
	
	@ModelAttribute("review")
    public Review createForm() {
        return new Review();
    }
}
