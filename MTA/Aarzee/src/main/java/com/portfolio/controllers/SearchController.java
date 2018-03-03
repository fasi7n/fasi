package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.portfolio.helperBeans.LoginCredentials;
import com.portfolio.model.SenderDetails;
import com.portfolio.model.UserDetails;
import com.portfolio.service.SenderDetailsService;
import com.portfolio.service.UserDetailsService;


@Controller
@RequestMapping("/search")
@SessionAttributes("loggedInUser")
public class SearchController {
	
@Autowired
private SenderDetailsService senderDetailsService;

@Autowired
private SenderDetails returnSenderDetails;
	
@GetMapping
public String searchAction(@ModelAttribute SenderDetails searchFormBean, Model model)
	{
	
	if(searchFormBean!=null)
	{
		returnSenderDetails = senderDetailsService.findSenderByEmail(searchFormBean.getSenderEmail());
		
		System.out.println(searchFormBean.getSenderEmail());
		model.addAttribute("searchSuccess", "SEARCH IS SUCCESSFUL");
		model.addAttribute("returnSenderSearchDetails", returnSenderDetails);
		//return "index";
		return "forward://indexAction(actVal='searchResults')";
	}
	
	else
	{
		//
	model.addAttribute("searchError", "ERROR - Please search with correct details");
	//forward to indexAction under UderIndexController
	//Then add the actVal attribute with search  - /indexAction(actVal='searchTxnAction')
	return "forward://indexAction(actVal='searchTxnAction')";
	}
	
	
	}

}
