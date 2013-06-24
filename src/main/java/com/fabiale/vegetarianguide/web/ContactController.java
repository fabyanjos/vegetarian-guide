package com.fabiale.vegetarianguide.web;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fabiale.vegetarianguide.model.Contact;
import com.fabiale.vegetarianguide.service.MailService;

@Controller
public class ContactController {
	
	@Autowired MailService mailService;
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "/contact";
	}
	
	@RequestMapping(value = "/contact/send", method = {RequestMethod.POST, RequestMethod.GET})
	public String send(@ModelAttribute("message") @Valid Contact contact, BindingResult result, ModelMap modelMap) throws AddressException, MessagingException {
		if(result.hasErrors()) 
			modelMap.addAttribute("error", "error.add.validation.restaurant");
		else {
			mailService.send(contact);
			modelMap.addAttribute("success", "success.send.email");
		}
		return "/contact";
	}
	
	@ModelAttribute("message")
    public Contact createForm() {
        return new Contact();
    }
}
