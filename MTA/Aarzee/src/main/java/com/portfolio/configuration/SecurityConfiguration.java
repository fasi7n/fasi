package com.portfolio.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.portfolio.commons.SimpleSHADigest;
import com.portfolio.model.LoginCredentials;
import com.portfolio.model.UserCredentials;
import com.portfolio.model.UserDetails;
import com.portfolio.model.UserRoles;
import com.portfolio.service.UserRolesService;
 
@Configuration
@EnableWebSecurity
@SessionAttributes("loggedInUser")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.
			authorizeRequests()
			//Permitted to all
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/newUserRegistration").permitAll()
				.antMatchers("/registrationAction").permitAll()
				.antMatchers("/indexAction/**").permitAll();
				
				//LETS add later
				//.antMatchers("/indexAction/**").hasRole("ADMIN").anyRequest()
				
				//	.anyRequest()
				//	.authenticated();
			
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring()
	       .antMatchers("/resources/**", "/templates/**", "/static/**", "/css/**", "/images/**", "/js/**", "/webjars/**");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.inMemoryAuthentication()
				.withUser("fasi@fasi.com")
			    .password("Fasi123!#")
			    .roles("ADMIN");
	}
	
	
}