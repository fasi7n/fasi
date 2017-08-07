package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.portfolio.model.LoginCredentials;
import com.portfolio.model.UserCredentials;
import com.portfolio.model.UserDetails;
import com.portfolio.service.UserCredentialsService;
import com.portfolio.service.UserDetailsService;


@Controller
@SessionAttributes("loggedInUser")
public class UserIndexController {
	
	@Value("${user.dash}")
	private String userDashMsg;
	
	@Autowired
	private UserCredentials userCredentials;
	
	@Autowired
	private UserDetails userDetails;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping("/indexAction")
	public ModelAndView userDashboardAction(@ModelAttribute("loggedInUser") UserCredentials loggedInUser, @RequestParam("actVal") String actVal, Model model)
	
	{
		
		ModelAndView mav = new ModelAndView("index");
		
		if(actVal.equalsIgnoreCase("dashboardAction"))
		{
			dashBoardProcessing(model, loggedInUser.getEmail_ID());
		}
		
		else if(actVal.equalsIgnoreCase("myDetailsAction"))
		{
			
			myDetailsProcessing(model);
		}
		
		
		else if(actVal.equalsIgnoreCase("myProfileAction"))
		{
			
			myProfileProcessing(model);
		}
		
		else if(actVal.equalsIgnoreCase("editProfileAction"))
		{
			
			editProfileProcessing(model);
		}
		
		
		
		
		return mav;
		
		
	}
	
	
	public void dashBoardProcessing(Model model, String loggedInUser)
	{
		
		model.addAttribute("myDashSelector", "dashSuccess");
		model.addAttribute("dashSuccess", "Have to display user dashboard here");
		
		model.addAttribute("userInfo", "userInfo");		
		model.addAttribute("userCredentials", userCredentials);
		
		System.out.println("LOGGED IN USER IS ++++++ RETRIEVED --- " + loggedInUser);
		
		userDetails = userDetailsService.getUserDetailsByEmail(loggedInUser);
		
		System.out.println("User Details RETRIEVED ---- " + userDetails.getFirstname() + userDetails.getLastname() + userDetails.getPhone());
		
		model.addAttribute("userDetails", userDetails);
		
		//return "index";
		
	}

	
	
	public void myDetailsProcessing(Model model)
	{
		
		model.addAttribute("myDetailsSelector", "myDetSuccess");
		model.addAttribute("myDetSuccess", "Have to display my details here");
	
		
	}

	

	public void myProfileProcessing(Model model)
	{
		
		model.addAttribute("myDetailsSelector", "myProfSuccess");
		model.addAttribute("myProfSuccess", "Have to display MY PROFILE here");
	
		
	}
	

	public void editProfileProcessing(Model model)
	{
		
		model.addAttribute("myDetailsSelector", "editProfSuccess");
		model.addAttribute("editProfSuccess", "Have to display EDIT PROFILE FORM here");
	
		
	}
	
	
	
}
