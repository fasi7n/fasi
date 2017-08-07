package com.portfolio.service;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

@Service
public interface LoggerService {
	
	Log getLogger(String className);

}
