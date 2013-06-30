package com.fabiale.vegetarianguide.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("current", "home");
		return "index";
	}
}
