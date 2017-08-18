package com.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.portfolio.commons.SimpleSHADigest;
import com.portfolio.model.UserCredentials;
import com.portfolio.model.UserDetails;
import com.portfolio.model.UserRoles;
import com.portfolio.service.UserCredentialsService;
import com.portfolio.service.UserDetailsService;
import com.portfolio.service.UserRolesService;

@Component
public class LoadDummyContent {
	
	@Autowired
	private UserCredentials userCredentials;
	
	@Autowired
	private UserDetails userDetails;
	
	@Autowired
	private UserRoles userRole;
	
	@Autowired
	private UserCredentialsService userCredService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserRolesService userRolesService;
	
	
	public void loadDummyData(){
		
		
		userCredentials.setEmail_ID("fasi@fasi.com");
		userCredentials.setPassword(SimpleSHADigest.mySha1("Fasi123!#"));
		
		userDetails.setEmail_ID("fasi@fasi.com");
		userDetails.setFirstname("Fasi");
		userDetails.setLastname("Uddin");
		userDetails.setPhone("123-456-7890");
		
		userRole.setEmail_ID("fasi@fasi.com");
		userRole.setRolename("ADMIN");
		
		String actionResult1 = userCredService.createUserByEmail(userCredentials);
		String actionResult2 = userDetailsService.createUserDetailsByEmail(userDetails);
		String actionResult3 = userRolesService.createUserRolesByEmail(userRole);
		
		if(actionResult1.equalsIgnoreCase("success") && actionResult2.equalsIgnoreCase("success") && actionResult3.equalsIgnoreCase("success"))
		System.out.println("Dummy user created with email = " + userCredentials.getEmail_ID() + " and password = Fasi123!#");
		System.out.println("Dummy user Details created with First Name: " + userDetails.getFirstname() + " Last name: " + userDetails.getLastname() + " Phone: " + userDetails.getPhone());
		System.out.println("Dummy user ROLE created with Role Name: " + userRole.getRolename());
		
	}

}
