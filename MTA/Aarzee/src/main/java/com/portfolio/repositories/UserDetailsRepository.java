package com.portfolio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.portfolio.model.UserDetails;

@Component

public interface UserDetailsRepository extends CrudRepository<UserDetails, String> {

}
