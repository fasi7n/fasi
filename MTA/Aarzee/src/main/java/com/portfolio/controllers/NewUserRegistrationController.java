package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.helperBeans.LoginCredentials;

@Controller
@RequestMapping("/newUserRegistration")
public class NewUserRegistrationController {
	
	@Autowired
	private LoginCredentials loginCredentials;
	
	@GetMapping
	public String newUserRegistrationAction(Model model)
	
	{
		
		model.addAttribute("loginCredentials", loginCredentials);
		return "register";
	}
	
	

}
