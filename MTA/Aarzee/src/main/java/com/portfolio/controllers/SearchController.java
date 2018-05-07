package com.portfolio.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
private List<SenderDetails> returnSenderSearchResults;

@Qualifier("newSenderDetailsBean")
@Autowired
private SenderDetails searchSenderDetails;


@PostMapping
public @ResponseBody List<SenderDetails> searchAction(@ModelAttribute("senderSearchFormBean") SenderDetails senderSearchFormBean, @RequestBody String searchJson,
														BindingResult bindingResult, Model model)
	{
	
	//String searchResult = "";
	//verification
	System.out.println("RESULT OF SENDER FORM BEAN----------------->>>>>>>>"+searchJson+"<<<>>>>>>>>"+searchJson);
	 
	System.out.println("senderSearchFormBean is NOT null" + (senderSearchFormBean) != null? true:false  );
	
	//MUST ADD RESET OF searchResultsSuccess in userIndexController or i will keep seeing older results everytime search page is visited.
	//MUST ALSO SET or rename the senderDetails BEANS on dummy data creation and new txn (have to add beans to Config to return New or change obj name)
	
	
	
	if(senderSearchFormBean!=null)
	{
		if(senderSearchFormBean.getSenderEmail()!=null){
			searchSenderDetails = senderDetailsService.findSenderByEmail(senderSearchFormBean.getSenderEmail());
			if (searchSenderDetails != null){
				returnSenderSearchResults.add(searchSenderDetails);
				model.addAttribute("searchResultsSuccess", "SEE SEARCH RESULTS BELOW");
				model.addAttribute("senderSearchResults", returnSenderSearchResults);
				//searchResult = "success";
				//return returnSenderSearchResults;
			}
		}
		
		else if(senderSearchFormBean.getPrimaryPhone()!=null){
			searchSenderDetails = senderDetailsService.findSenderByPhone(senderSearchFormBean.getPrimaryPhone());
			if (searchSenderDetails != null){
				returnSenderSearchResults.add(searchSenderDetails);			
				model.addAttribute("searchResultsSuccess", "SEE SEARCH RESULTS BELOW");
				model.addAttribute("senderSearchResults", returnSenderSearchResults);
				//searchResult = "success";
				//return returnSenderSearchResults;
			}
		}
	
		else if(senderSearchFormBean.getFirstName()!=null){
			returnSenderSearchResults = senderDetailsService.findAllSenderByFirst(senderSearchFormBean.getFirstName());
			if(returnSenderSearchResults!=null) {
				model.addAttribute("searchResultsSuccess", "SEE SEARCH RESULTS BELOW");
				model.addAttribute("senderSearchResults", returnSenderSearchResults);
				//searchResult = "success";
				//return returnSenderSearchResults;
			}
		}
	
		else if(senderSearchFormBean.getLastName()!=null){
			returnSenderSearchResults = senderDetailsService.findAllSenderByLast(senderSearchFormBean.getLastName());
			if(returnSenderSearchResults!=null) {
				model.addAttribute("searchResultsSuccess", "SEE SEARCH RESULTS BELOW");			
				model.addAttribute("senderSearchResults", returnSenderSearchResults);
				//searchResult = "success";
				//return returnSenderSearchResults;
			}
		}
		
		else
		{
			model.addAttribute("searchResultsFailure", "Error - No results found. Please enter correct information");
			return returnSenderSearchResults;
		}

	
	}
	
	else
	{
		model.addAttribute("searchResultsFailure", "Error - No results found. Please enter correct information");
		return returnSenderSearchResults;
	}
	
	
	return returnSenderSearchResults;
	
	}

}
