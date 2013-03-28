package com.fabiale.vegetarianguide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fabiale.vegetarianguide.service.CountryService;

@Controller
public class MyController {
	
	@Autowired CountryService countryService;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("countries", countryService.getAll());
		return "index";
	}
}
