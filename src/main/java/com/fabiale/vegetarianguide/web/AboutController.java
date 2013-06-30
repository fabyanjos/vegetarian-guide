package com.fabiale.vegetarianguide.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String init(ModelMap map) {
		map.addAttribute("current", "about");
		return "/about";
	}
}
