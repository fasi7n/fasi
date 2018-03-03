package com.portfolio.configuration;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.portfolio.LoadDummyContent;
import com.portfolio.dao.SenderDetailsDAO;
import com.portfolio.dao.SenderDetailsDAOImpl;
import com.portfolio.model.UserCredentials;
import com.portfolio.model.UserDetails;
import com.portfolio.model.UserRoles;
import com.portfolio.service.LoggerService;
import com.portfolio.service.SenderDetailsService;
import com.portfolio.service.SenderDetailsServiceImpl;
import com.portfolio.service.UserCredentialsService;
import com.portfolio.service.UserCredentialsServiceImpl;
import com.portfolio.serviceImpl.LoggerServiceImpl;

@Configuration
public class AppConfiguration {
	
	
	@Bean
	public LoggerService loggerService()
	{
		return new LoggerServiceImpl();
	}
	
	

	/*public UserCredentialsService userCredentialsService()
	{
		return new UserCredentialsServiceImpl();
	} */
	
	

	@Bean
	public UserCredentials userCredentials()
	{
		return new UserCredentials();
	}

	
	@Bean
	public LoadDummyContent loadDummyContent()
	{
		return new LoadDummyContent();
	}
	
	@Bean
	public UserDetails userDetials()
	{
		return new UserDetails();
	}
	
	@Bean
	public UserRoles userRoles()
	{
		return new UserRoles();
	}
	
	@Bean
	public SenderDetailsService senderDetailsService()
	{
		return new SenderDetailsServiceImpl();
	}
	
	@Bean
	public SenderDetailsDAO senderDetailsDAO()
	{
		return new SenderDetailsDAOImpl();
	}
	
	
	

}
