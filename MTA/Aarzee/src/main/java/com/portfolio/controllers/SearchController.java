package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.portfolio.helperBeans.LoginCredentials;
import com.portfolio.model.UserDetails;
import com.portfolio.service.UserDetailsService;


@Controller
@RequestMapping("/search")
@SessionAttributes("loggedInUser")
public class SearchController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired UserDetails userSearchDetails;
	
@GetMapping
public String searchAction(@ModelAttribute LoginCredentials searchFormBean, Model model)
	{
	
	if(searchFormBean!=null)
	{
		userSearchDetails = userDetailsService.getUserDetailsByEmail(searchFormBean.getEmail_ID());
		
		System.out.println(searchFormBean.getEmail_ID());
		model.addAttribute("searchSuccessReturn", "SEARCH IS SUCCESSFUL - Please search with correct details");
		model.addAttribute("userSearchDetails", userSearchDetails);
		//return "index";
		return "forward://indexAction(actVal='searchResults')";
	}
	
	else
	{
		//
	model.addAttribute("searchError", "ERROR - Please search with correct details");
	//forward to indexAction under UderIndexController
	//Then add the actVal attribute with search  - /indexAction(actVal='searchTxnAction')
	return "index";
	}
	
	
	}

}
