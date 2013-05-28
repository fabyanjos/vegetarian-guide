package com.fabiale.vegetarianguide.web;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.Review;
import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.service.RestaurantService;
import com.fabiale.vegetarianguide.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired ReviewService reviewService;
	@Autowired RestaurantService restaurantService;
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/restaurant/review/{id}", method = RequestMethod.GET)
	public String review(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("restaurantId", id);
		return "/restaurant/review";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/restaurant/review/save/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String save(@PathVariable("id") Integer id, @ModelAttribute("review") @Valid Review review, BindingResult result, ModelMap modelMap, RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			modelMap.addAttribute("restaurantId", id);
			modelMap.addAttribute("error", "error.add.validation.restaurant");
		} else {
			Restaurant restaurant = restaurantService.getById(id);
			review.setRestaurant(restaurant);
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			review.setUser(user);
			reviewService.create(review);
			redirectAttributes.addFlashAttribute("success", "success.save.restaurant");
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
