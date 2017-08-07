package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackageClasses = {DemoApplication.class, com.portfolio.configuration.AppConfiguration.class})

//@SpringBootApplication
public class DemoApplication {
	
	

	public static void main(String[] args) {
		
				
		SpringApplication.run(DemoApplication.class, args);
		
			
		
			}
}
