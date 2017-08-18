package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.model.UserDetails;
import com.portfolio.model.UserRoles;
import com.portfolio.repositories.UserCredentialsRepository;
import com.portfolio.repositories.UserDetailsRepository;
import com.portfolio.repositories.UserRolesRepository;

@Component
public class UserRolesDAOImpl implements UserRolesDAO {
	
	@Autowired
	private UserRolesRepository userRolesRepository;
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	
	public UserRoles getUserRolesByEmail(String userEmail){
		return userRolesRepository.findOne(userEmail);
				
	}
	
	
	public String createUserRolesByEmail(UserRoles userRoles){
		
		//userRoleRepo.save(userRoles);
		
		if((userCredentialsRepository.findOne(userRoles.getEmail_ID()) != null)
				&& (userDetailsRepository.findOne(userRoles.getEmail_ID()) != null))
		{
			userRolesRepository.save(userRoles);
				
		return "success";
		}
		else return "failure";
		
		
	}

}
