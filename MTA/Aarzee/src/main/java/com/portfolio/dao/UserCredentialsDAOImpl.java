package com.portfolio.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.model.UserCredentials;
import com.portfolio.repositories.UserCredentialsRepository;

@Component
public class UserCredentialsDAOImpl implements UserCredentialsDAO {
	
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepo;

	@Override
	public List<UserCredentials> getAllUsers() {
		
		return (List<UserCredentials>) userCredentialsRepo.findAll();
	}

	@Override
	public UserCredentials getUserByEmail(String userEmail) {
		
		return userCredentialsRepo.findOne(userEmail);
	}

	@Override
	public String createUserByEmail(UserCredentials newUser) {
		
		System.out.println(userCredentialsRepo.findOne(newUser.getEmail_ID()));
		
		if((userCredentialsRepo.findOne(newUser.getEmail_ID())) == null)
		{
			
			System.out.println(" ------- INSIDE IFFFFFFF");
			userCredentialsRepo.save(newUser);
		//userCredentialsRepo.save(newUser);
		System.out.println(" ------- AFTER SAVEEEEEEEEEEE");
		
		return "success";
		}
		else return "failure";
		
	}

	@Override
	public UserCredentials deleteUserByEmail(UserCredentials deleteUser) {		
		userCredentialsRepo.delete(deleteUser);		
		return deleteUser;
	}

	@Override
	public UserCredentials updateUserByEmail(UserCredentials newCredentials, String oldEmail) {
		
		UserCredentials oldUserDetails = userCredentialsRepo.findOne(oldEmail);
		oldUserDetails.setEmail_ID(newCredentials.getEmail_ID());
		oldUserDetails.setPassword(newCredentials.getPassword());
		userCredentialsRepo.save(oldUserDetails);
		
		// OR - just 
		//userCredentialsRepo.save(newCredentials);
		
		return userCredentialsRepo.findOne(newCredentials.getEmail_ID());
	}

}
