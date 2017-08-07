package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.portfolio.commons.SimpleSHADigest;
import com.portfolio.model.LoginCredentials;
import com.portfolio.model.UserCredentials;
import com.portfolio.service.UserCredentialsService;

@Controller
@RequestMapping("/login")
@SessionAttributes("loggedInUser")
public class LoginActionController {
	
	
	@Value("${welcome.message}")
	private String welcomeMessage;

	@Autowired
	private UserCredentialsService userCredServObj;
	

	
		
	@PostMapping
	public String loginAction(@ModelAttribute LoginCredentials loginCredentials, Model model)
	{
		
		System.out.println("  -------------------- login address  "+loginCredentials.getEmail_ID());
		System.out.println("  -------------------- login pass   "+loginCredentials.getPassword());
		System.out.println("User Credential VALUE IS NULL ----------- " + (userCredServObj==null));
		
		UserCredentials userCredentials = userCredServObj.getUserByEmail(loginCredentials.getEmail_ID());
				
		if(userCredentials==null)
		{
			model.addAttribute("error", "Incorrect Login Details");
			//return "redirect:/";
			
			return "login";
		}
		
		else
		{
			if(userCredentials.getEmail_ID().equalsIgnoreCase(loginCredentials.getEmail_ID())
					&& userCredentials.getPassword().equals(SimpleSHADigest.mySha1(loginCredentials.getPassword())))
				{		
					model.addAttribute("welcomeMessage", welcomeMessage);
					
					System.out.println("WHILE SETTING USER CREDENTIALS --- " + userCredentials.getEmail_ID());
					UserCredentials loggedInUser = userCredentials;
					System.out.println("WHILE SETTING LOGGED IN USER --- " + loggedInUser.getEmail_ID());
					model.addAttribute("loggedInUser", loggedInUser);
					
					return "index";
				}
			
			else
				{
				model.addAttribute("error", "Internal Error");
				//return "redirect:/";
				
				return "login";
				}
		}
		
		
		
		
		
		
	}
	
	
	
	

}
