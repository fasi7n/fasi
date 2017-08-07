package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolio.LoadDummyContent;
import com.portfolio.model.LoginCredentials;


@Controller
public class LoginController {
	
	@Autowired
	private LoginCredentials loginCredentials;
	
	@Autowired
	private LoadDummyContent loadDummyContent;
	

@RequestMapping("/")
public String login(Model model, @RequestParam(value="error", required=false) String error)
	
	{
	
	model.addAttribute("loginCredentials", loginCredentials);
	loadDummyContent.loadDummyData();
	
	
	
	if(error!=null)
	{
		model.addAttribute("error", error);
	}
	
	
		return "login";
	}
	
	

}
