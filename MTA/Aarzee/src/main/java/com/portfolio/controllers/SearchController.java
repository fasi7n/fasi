package com.portfolio.controllers;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

import com.google.gson.Gson;
import com.portfolio.helperBeans.LoginCredentials;
import com.portfolio.helperBeans.SearchTxnBean;
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
public  @ResponseBody List<SenderDetails> searchAction(@RequestBody String searchInput,													   	
													   @ModelAttribute("senderSearchFormBean") SenderDetails senderSearchFormBean, 
													   Model model)
	{
	
	
	Gson gson = new Gson();
	SearchTxnBean mySearch = gson.fromJson(searchInput, SearchTxnBean.class);
	
	System.out.println("AJAX to Controller ------->"+searchInput);
	 
	System.out.println("AJAX to Controller ------->"+mySearch.getSelectedInputName() + "  " + mySearch.getSelectedInputValue());
	 
	//System.out.println("senderSearchFormBean is NOT null" + (senderSearchFormBean) != null? true:false  );
	
	//System.out.println("SENDER EMAIL ----------------->>>>>>>>" + searchInput.getSenderEmail()  );
	
	//MUST ADD RESET OF searchResultsSuccess in userIndexController or i will keep seeing older results everytime search page is visited.
	//MUST ALSO SET or rename the senderDetails BEANS on dummy data creation and new txn (have to add beans to Config to return New or change obj name)
	
	
	
	if(mySearch.getSelectedInputName()!=null &&  mySearch.getSelectedInputValue()!=null)
	{
		System.out.println("inside IF in search controller");
		
		if(mySearch.getSelectedInputName().equalsIgnoreCase("senderEmail")){
			System.out.println("inside search by email method");
			searchSenderDetails = senderDetailsService.findSenderByEmail(mySearch.getSelectedInputValue());
			if (searchSenderDetails != null){
				returnSenderSearchResults.add(searchSenderDetails);
				model.addAttribute("searchResultsSuccess", "SEE SEARCH RESULTS BELOW");
				model.addAttribute("senderSearchResults", returnSenderSearchResults);
				//searchResult = "success";
				//return returnSenderSearchResults;
			}
		}
		
		else if(mySearch.getSelectedInputName().equalsIgnoreCase("primaryPhone")){
			searchSenderDetails = senderDetailsService.findSenderByPhone(mySearch.getSelectedInputValue());
			if (searchSenderDetails != null){
				returnSenderSearchResults.add(searchSenderDetails);			
				model.addAttribute("searchResultsSuccess", "SEE SEARCH RESULTS BELOW");
				model.addAttribute("senderSearchResults", returnSenderSearchResults);
				//searchResult = "success";
				//return returnSenderSearchResults;
			}
		}
	
		else if(mySearch.getSelectedInputName().equalsIgnoreCase("firstName")){
			returnSenderSearchResults = senderDetailsService.findAllSenderByFirst(mySearch.getSelectedInputValue());
			if(returnSenderSearchResults!=null) {
				model.addAttribute("searchResultsSuccess", "SEE SEARCH RESULTS BELOW");
				model.addAttribute("senderSearchResults", returnSenderSearchResults);
				//searchResult = "success";
				//return returnSenderSearchResults;
			}
		}
	
		else if(mySearch.getSelectedInputName().equalsIgnoreCase("lastName")){
			returnSenderSearchResults = senderDetailsService.findAllSenderByLast(mySearch.getSelectedInputValue());
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
	
	System.out.println("Before return from search controller");
	Iterator<SenderDetails> myIte = returnSenderSearchResults.iterator(); 
	while(myIte.hasNext() )
	System.out.println(myIte.next());
	
	return returnSenderSearchResults;
	
	}

}
