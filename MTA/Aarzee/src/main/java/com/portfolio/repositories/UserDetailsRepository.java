package com.portfolio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.portfolio.model.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, String> {
	
	

}
