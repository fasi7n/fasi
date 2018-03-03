package com.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.portfolio.model.SenderDetails;

@Service
public interface SenderDetailsService {
	
	public SenderDetails findSenderByEmail(String senderEmail);
	public SenderDetails findSenderByPhone(String senderPhone);
	public List<SenderDetails> findSenderByFirst(String senderFirst);
	public List<SenderDetails> findSenderByLast(String senderLast);
	public SenderDetails saveSender(SenderDetails senderDetails);
	

}
