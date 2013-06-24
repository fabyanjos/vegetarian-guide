package com.fabiale.vegetarianguide.web;

import java.io.IOException;
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

import com.dropbox.client2.exception.DropboxException;
import com.fabiale.vegetarianguide.model.Image;
import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.service.ImageService;
import com.fabiale.vegetarianguide.service.RestaurantService;

@Controller
public class ImageController {
	
	@Autowired RestaurantService restaurantService;
	@Autowired ImageService imageService;
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/restaurant/image/{id}", method = RequestMethod.GET)
	public String review(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("restaurantId", id);
		return "/restaurant/image";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/restaurant/image/save/{id}", method = {RequestMethod.POST, RequestMethod.GET})
	public String save(@PathVariable("id") Integer id, @ModelAttribute("image") @Valid Image image, BindingResult result, ModelMap modelMap, RedirectAttributes redirectAttributes) throws IOException, DropboxException {
		
		if (result.hasErrors()) {
			modelMap.addAttribute("restaurantId", id);
			modelMap.addAttribute("error", "error.add.validation.restaurant");
			return "/restaurant/image";
		} else {
			Restaurant restaurant = restaurantService.getById(id);
			image.setRestaurant(restaurant);
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			image.setUser(user);
			image.setFilename(image.getFile().getOriginalFilename());
			imageService.upload(image, image.getFile().getBytes());
			redirectAttributes.addFlashAttribute("success", "success.save.restaurant");
			return "redirect:/restaurant/details/" + id;
		}
	}
	
	@RequestMapping(value = "/image/list/{qtd}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<Image> getLastUpdates(@PathVariable("qtd") int qtd) {
		return imageService.getLastUptades(qtd);
	}
	
	@ModelAttribute("image")
    public Image createForm() {
        return new Image();
    }
}
