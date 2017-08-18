package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
		
		/*STARTS HERE
		UserCredentials testCredentials =
				 (UserCredentials)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			testCredentials = (UserCredentials) auth.getPrincipal();
			System.out.println("++++----++++---- This is a test ID " + testCredentials.getEmail_ID() +"SOME PASS "+ testCredentials.getPassword());
		}
	*/ //ENDS HERE	
		
		
		//ONE MORE 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    String currentUserName = authentication.getName();
		    System.out.println(currentUserName);
		}
		
		
		//STARTS HERE
		String testCredentials = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("++++----++++---- This is a test ID 1 FOR THE LOGGED in USER " + testCredentials);
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			testCredentials = (String) auth.getPrincipal();
			System.out.println("++++----++++---- This is a test ID 2 FOR THE LOGGED in USER " + testCredentials);
		}
	//ENDS HERE	
				
		if((userCredentials==null) || !(userCredentials.getPassword().equals(SimpleSHADigest.mySha1(loginCredentials.getPassword()))))
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
				model.addAttribute("error", "Internal Error - Contact Admin");
				//return "redirect:/";
				
				return "login";
				}
		}
		
		
		
		
		
		
	}
	
	
	
	

}
