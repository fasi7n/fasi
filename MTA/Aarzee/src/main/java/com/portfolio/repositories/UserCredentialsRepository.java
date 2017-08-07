package com.portfolio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.portfolio.model.UserCredentials;

@Component
public interface UserCredentialsRepository extends CrudRepository<UserCredentials, String> {
	
	

}
