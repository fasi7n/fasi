package com.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.dao.UserDetailsDAO;
import com.portfolio.model.UserDetails;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	

	@Override
	public String createUserDetailsByEmail(UserDetails userDetails) {
		
		return userDetailsDAO.createUserDetailsByEmail(userDetails);
	}
	
	
	@Override
	public UserDetails getUserDetailsByEmail(String userEmail) {
		
		return userDetailsDAO.getUserDetailsByEmail(userEmail);
	}

}
