package com.portfolio.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class UserCredentials {

	@Id
	@Column(name="EMAIL")
	private String email_ID;
	
	@NotEmpty
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private UserDetails userDetails;

	public String getEmail_ID() {
		
		return email_ID;
		
	}
	
	public void setEmail_ID(String email_ID) {
		
		this.email_ID = email_ID;
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password) {
		
		this.password = password;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
	
	
	
}
 