package com.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.dao.UserCredentialsDAO;
import com.portfolio.model.UserCredentials;
import com.portfolio.repositories.UserCredentialsRepository;

@Component
public class UserCredentialsServiceImpl implements UserCredentialsService {
	
	@Autowired
	private UserCredentialsDAO userCredentialsDAO;
	


	@Override
	public List<UserCredentials> getAllUsers() {		
		
		return userCredentialsDAO.getAllUsers();
	}
	

	@Override
	public UserCredentials getUserByEmail(String userEmail) {

		return userCredentialsDAO.getUserByEmail(userEmail);
		
	}

	
	@Override
	public String createUserByEmail(UserCredentials newUserDetails) {
		
		return userCredentialsDAO.createUserByEmail(newUserDetails);
		
		
	}

	
	@Override
	public UserCredentials deleteUserByEmail(UserCredentials deleteUser) {
					
		return userCredentialsDAO.deleteUserByEmail(deleteUser);
	}


	@Override
	public UserCredentials updateUserByEmail(UserCredentials newCredentials, String oldEmail) {
		
		return userCredentialsDAO.updateUserByEmail(newCredentials, oldEmail);
	}
	
	
	

}
