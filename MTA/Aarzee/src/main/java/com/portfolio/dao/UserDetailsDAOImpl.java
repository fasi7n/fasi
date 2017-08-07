package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.model.UserDetails;
import com.portfolio.repositories.UserCredentialsRepository;
import com.portfolio.repositories.UserDetailsRepository;

@Component
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	@Override
	public UserDetails getUserDetailsByEmail(String userEmail) {
		
		return userDetailsRepository.findOne(userEmail);
		
		
	}

	@Override
	public String createUserDetailsByEmail(UserDetails userDetails) {
		
		
		if((userCredentialsRepository.findOne(userDetails.getEmail_ID())) != null
				&& userDetailsRepository.findOne(userDetails.getEmail_ID()) == null)
		{
			userDetailsRepository.save(userDetails);
				
		return "success";
		}
		else return "failure";
		
	}

}
