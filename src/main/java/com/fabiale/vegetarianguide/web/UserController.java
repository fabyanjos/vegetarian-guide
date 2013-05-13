package com.fabiale.vegetarianguide.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.service.UserService;

@Controller
public class UserController {
	
	@Autowired UserService service;
	
	@RequestMapping(value="/rest/user", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PUT)
	@ResponseBody
	public User user(@RequestBody User user) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        User result = service.findByLogin(user.getLogin());
        if(result != null) {
        	session.setAttribute("user", result);
        	return result;
        } else {
        	service.create(user);
        	session.setAttribute("user", user);
        	return user;
        }
	}
	
	@RequestMapping(value="/rest/user/logout", method = RequestMethod.GET)
	public String logout() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        session.invalidate();
        
        return "redirect:/";
	}
	
	@RequestMapping(value = "/signin")
	public String login() {
		return "login";
	}
}
