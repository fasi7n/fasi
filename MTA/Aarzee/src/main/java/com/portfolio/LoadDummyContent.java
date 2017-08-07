package com.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.portfolio.commons.SimpleSHADigest;
import com.portfolio.model.UserCredentials;
import com.portfolio.model.UserDetails;
import com.portfolio.service.UserCredentialsService;
import com.portfolio.service.UserDetailsService;

@Component
public class LoadDummyContent {
	
	@Autowired
	private UserCredentials userCredentials;
	
	@Autowired
	private UserDetails userDetails;
	
	@Autowired
	private UserCredentialsService userCredServObj;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	public void loadDummyData(){
		
		
		userCredentials.setEmail_ID("fasi@fasi.com");
		userCredentials.setPassword(SimpleSHADigest.mySha1("Fasi123!#"));
		
		userDetails.setEmail_ID("fasi@fasi.com");
		userDetails.setFirstname("Fasi");
		userDetails.setLastname("Uddin");
		userDetails.setPhone("123-456-7890");
		
		String actionResult1 = userCredServObj.createUserByEmail(userCredentials);
		String actionResult2 = userDetailsService.createUserDetailsByEmail(userDetails);
		
		if(actionResult1.equalsIgnoreCase("success") && actionResult2.equalsIgnoreCase("success"))
		System.out.println("Dummy user created with email = " + userCredentials.getEmail_ID() + " and password = Fasi123!#");
		System.out.println("Dummy user Detailas created with First Name: " + userDetails.getFirstname() + " Last name: " + userDetails.getLastname() + " Phone: " + userDetails.getPhone());
		
		
	}

}
