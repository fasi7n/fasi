package com.portfolio.service;

import org.springframework.stereotype.Service;

import com.portfolio.model.UserDetails;

@Service
public interface UserDetailsService {
	
	public UserDetails getUserDetailsByEmail(String userEmail);
	public String createUserDetailsByEmail(UserDetails userDetails);

}
