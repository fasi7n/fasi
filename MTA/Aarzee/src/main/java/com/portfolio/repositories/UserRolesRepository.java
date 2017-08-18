package com.portfolio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.portfolio.model.UserRoles;

@Component
public interface UserRolesRepository extends CrudRepository<UserRoles, String>  {

}
