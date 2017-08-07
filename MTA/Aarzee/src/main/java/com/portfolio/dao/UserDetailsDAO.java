package com.portfolio.dao;

import org.springframework.stereotype.Component;

import com.portfolio.model.UserDetails;


public interface UserDetailsDAO {
	
	public UserDetails getUserDetailsByEmail(String userEmail);
	public String createUserDetailsByEmail(UserDetails userDetails);

}
