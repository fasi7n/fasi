package com.portfolio.service;

import org.springframework.stereotype.Service;
import com.portfolio.model.UserRoles;

@Service
public interface UserRolesService {

	public UserRoles getUserRolesByEmail(String userEmail);
	public String createUserRolesByEmail(UserRoles userRole);
	
}
