package com.portfolio.dao;

import java.util.List;

import com.portfolio.model.UserCredentials;

public interface UserCredentialsDAO {
	
	
	public List<UserCredentials> getAllUsers();
	
	public UserCredentials getUserByEmail(String userEmail);
	
	public String createUserByEmail(UserCredentials newUser);

	public UserCredentials deleteUserByEmail(UserCredentials deleteUser);
	
	public UserCredentials updateUserByEmail(UserCredentials newCredentials, String oldEmail);

}
