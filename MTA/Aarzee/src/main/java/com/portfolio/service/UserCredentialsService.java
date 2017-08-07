package com.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.portfolio.model.UserCredentials;


@Service
public interface UserCredentialsService {
	
	public List<UserCredentials> getAllUsers();
	
	public UserCredentials getUserByEmail(String userEmail);
	
	public String createUserByEmail(UserCredentials newUser);

	public UserCredentials deleteUserByEmail(UserCredentials deleteUser);
	
	public UserCredentials updateUserByEmail(UserCredentials newCredentials, String oldEmail);
	
	
}
