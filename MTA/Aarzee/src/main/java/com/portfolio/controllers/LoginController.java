package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.LoadDummyContent;
import com.portfolio.helperBeans.LoginCredentials;


@Controller
public class LoginController {
	
	@Autowired
	private LoginCredentials loginCredentials;
	
	@Autowired
	private LoadDummyContent loadDummyContent;
	

//@RequestMapping(value="/", method=RequestMethod.GET)
@RequestMapping("/")
public String login(Model model, @RequestParam(value="error", required=false) String error)
	
	{
	
	//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //String name = auth.getName(); //get logged in username
    //model.addAttribute("userNameSec", name);

	model.addAttribute("loginCredentials", loginCredentials);
	loadDummyContent.loadDummyData();
	
	
	
	if(error!=null)
	{
		model.addAttribute("error", error);
	}
	
	
		return "login";
	}
	
	

}
