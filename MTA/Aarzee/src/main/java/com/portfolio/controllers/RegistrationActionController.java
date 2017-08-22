package com.portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portfolio.commons.SimpleSHADigest;
import com.portfolio.helperBeans.LoginCredentials;
import com.portfolio.model.UserCredentials;
import com.portfolio.model.UserDetails;
import com.portfolio.repositories.UserCredentialsRepository;
import com.portfolio.service.UserCredentialsService;

@Controller
@RequestMapping("/registrationAction")
public class RegistrationActionController {
	
	@Autowired
	private UserCredentials userCredentials;
		
	@Autowired
	private UserCredentialsService userCredServObj;
	
	@Autowired
	private UserDetails userDetails;
	
	@Value("${email.taken.msg}")
	private String emailTaken;
	
	@Value("${register.success.msg}")
	private String registerSuccessMsg;
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepo;
	
	@PostMapping
	public String registrationAction(@ModelAttribute LoginCredentials loginCredentials,  Model model)
	{
		
		userCredentials.setEmail_ID(loginCredentials.getEmail_ID());
		userCredentials.setPassword(SimpleSHADigest.mySha1(loginCredentials.getPassword()));
		userDetails.setEmail_ID(loginCredentials.getEmail_ID());
		userDetails.setFirstname(loginCredentials.getfName());
		userDetails.setLastname(loginCredentials.getlName());
		userDetails.setPhone(loginCredentials.getPhone());
		userCredentials.setUserDetails(userDetails);
		
		String actionResult = userCredServObj.createUserByEmail(userCredentials);
		
		if(actionResult.equalsIgnoreCase("success"))
		{
			model.addAttribute("loginCredentials", userCredentials);
			model.addAttribute("registerSuccess", registerSuccessMsg);
			return "login";
		}
		
		else
		{
		model.addAttribute("error", emailTaken);
		return "register";
		}
		
		
	}
	
	
	@RequestMapping("/verifyEmailTaken")
	public @ResponseBody String verifyEmailTaken(@RequestParam("email") String email){
		
		System.out.println("Received email is   =========== " + email);
		UserCredentials result = userCredentialsRepo.findOne(email);
		
		if(result!=null)
		{
		System.out.println("Verify email method reached and called  =========== " + result.getEmail_ID());
		
		return result.getEmail_ID();
		}
		
		else return "allowedToCreate";
		
		
	}

}
