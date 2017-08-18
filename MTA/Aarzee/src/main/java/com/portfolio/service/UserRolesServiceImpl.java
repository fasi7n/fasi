package com.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.dao.UserRolesDAO;
import com.portfolio.model.UserRoles;

@Component
public class UserRolesServiceImpl implements UserRolesService{

	@Autowired
	private UserRolesDAO userRolesDAO;
	
	
	@Override
	public UserRoles getUserRolesByEmail(String userEmail) {
		return userRolesDAO.getUserRolesByEmail(userEmail);
		 
	}

	@Override
	public String createUserRolesByEmail(UserRoles userRole) {
		return userRolesDAO.createUserRolesByEmail(userRole);
	}

}
