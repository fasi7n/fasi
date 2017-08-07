package com.portfolio.serviceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.portfolio.service.LoggerService;

@Component
public class LoggerServiceImpl implements LoggerService{

	@Override
	public Log getLogger(String className) {
		
		final Log log = LogFactory.getLog(className);
		return log;
	}
	
	

}
