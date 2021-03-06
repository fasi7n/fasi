package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.portfolio.model.ReceiverDetails;
import com.portfolio.model.SenderDetails;
import com.portfolio.model.UserCredentials;
import com.portfolio.model.UserDetails;
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
	
	@Autowired
	private SenderDetails senderDetailsFormBean;
	
	@Autowired
	private ReceiverDetails receiverDetailsFormBean;
	
	@Qualifier("newSenderDetailsBean")
	@Autowired
	private SenderDetails senderSearchFormBean;
	

	
	@RequestMapping("/indexAction")
	public ModelAndView userDashboardAction(@ModelAttribute("loggedInUser") UserCredentials loggedInUser, @RequestParam("actVal") String actVal, Model model)
	
	{
		
		ModelAndView mav = new ModelAndView("index");
		
		
		if(actVal.equalsIgnoreCase("dashboardAction"))
		{
			dashBoardProcessing(model, loggedInUser.getEmail_ID());
		}
		
			
		
		else if(actVal.equalsIgnoreCase("searchTxnAction"))
		{
			
			//myProfileProcessing(model);
			searchTxnProcessing(model);
		}
		
		
		else if(actVal.equalsIgnoreCase("searchResults"))
		{
			
			//myProfileProcessing(model);
			searchResultsProcessing(model);
		}
		
		
		
		else if(actVal.equalsIgnoreCase("newTxnAction"))
		{
			
			//editProfileProcessing(model);
			newTxnProcessing(model);
		}
		
		else if(actVal.equalsIgnoreCase("reportsAction"))
		{
			
			//myDetailsProcessing(model);
			reportsProcessing(model);
		}
		
		else if(actVal.equalsIgnoreCase("complianceSetAction"))
		{
			
			//myDetailsProcessing(model);
			complainceSetProcessing(model);
		}
		
		else if(actVal.equalsIgnoreCase("exchangeRatesAction"))
		{
			
			//myDetailsProcessing(model);
			exchangeRatesProcessing(model);
		}
		
		else if(actVal.equalsIgnoreCase("userCtrlAction"))
		{
			userCtrlProcessing(model);
			//myDetailsProcessing(model);
		}
		
		else if(actVal.equalsIgnoreCase("curUserCtrlAction"))
		{
			curUserCtrlProcessing(model);
			//myDetailsProcessing(model);
		}
		
		
		else if(actVal.equalsIgnoreCase("logoutAction"))
		{
			logoutProcessing(model);
			//myDetailsProcessing(model);
		}
		
		return mav;
		
		
	}
	
	
	public void dashBoardProcessing(Model model, String loggedInUser)
	{
		
		model.addAttribute("myDashSelector", "dashSuccess");
		model.addAttribute("successOnDashboard", "Have to display user dashboard here");
		
		model.addAttribute("userInfo", "userInfo");		
		model.addAttribute("userCredentials", userCredentials);
		
		System.out.println("LOGGED IN USER IS ++++++ RETRIEVED --- " + loggedInUser);
		
		userDetails = userDetailsService.getUserDetailsByEmail(loggedInUser);
		
		System.out.println("User Details RETRIEVED ---- " + userDetails.getFirstname() + userDetails.getLastname() + userDetails.getPhone());
		
		model.addAttribute("userDetails", userDetails);
		
		//return "index";
		
	}

	
	
	public void searchTxnProcessing(Model model)
	{
		
		model.addAttribute("transactionSelector", "searchTxnSuccess");
		model.addAttribute("senderSearchFormBean", senderSearchFormBean);
		model.addAttribute("successfulSearchTxn", "Have to display SEARCH transactions here");
	
		
	}

	
	public void searchResultsProcessing(Model model)
	{
		
		model.addAttribute("transactionSelector", "searchResultSuccess");
		//model.addAttribute("searchFormBean", searchFormBean);
		model.addAttribute("successSearchResult", "Have to display SEARCH transactions here");
	
		
	}
	

	public void newTxnProcessing(Model model)
	{
		
		model.addAttribute("transactionSelector", "newTxnSuccess");
		model.addAttribute("senderDetailsFormBean", senderDetailsFormBean);
		model.addAttribute("receiverDetailsFormBean", receiverDetailsFormBean);
		model.addAttribute("successfulNewTxn", "Have to display NEW transaction here");
			
	}
	

	public void reportsProcessing(Model model)
	{
		
		model.addAttribute("reportsSelector", "reportsSuccess");
		model.addAttribute("successfulReports", "Have to display REPORTS here");
			
	}
	
	public void complainceSetProcessing(Model model)
	{
		
		model.addAttribute("adminCtrlSelector", "complaianceSetSuccess");
		model.addAttribute("successfulSetCompliance", "Have to display COMPLIANCES here");
			
	}
	
	public void exchangeRatesProcessing(Model model)
	{
		
		model.addAttribute("adminCtrlSelector", "exchangeRatesSuccess");
		model.addAttribute("successfulRates", "Have to display RATES SETTINGS here");
			
	}
	
	
	public void userCtrlProcessing(Model model)
	{
		
		model.addAttribute("adminCtrlSelector", "userCtrlSuccess");
		model.addAttribute("successfulUserCtrl", "Have to display USER CONTROLS here");
			
	}
	
	public void curUserCtrlProcessing(Model model)
	{
		
		model.addAttribute("curUserSelector", "curUserCtrlSuccess");
		model.addAttribute("successfulcurUserCtrl", "Have to display CURRENT USER SETTINGS HERE here");
			
	}
	
	
	
	
	public void logoutProcessing(Model model)
	{
		
		model.addAttribute("curUserSelector", "curUserLogoutSuccess");
		model.addAttribute("successfulLogout", "Have to ADD LOGOUT CODE ON CLICK");
		
	}
	
}
