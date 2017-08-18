package com.portfolio.dao;

import org.springframework.stereotype.Component;

import com.portfolio.model.UserRoles;

public interface UserRolesDAO {
	
	public UserRoles getUserRolesByEmail(String userEmail);
	public String createUserRolesByEmail(UserRoles userRoles);

}
