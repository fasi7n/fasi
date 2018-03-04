package com.portfolio.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.portfolio.model.SenderDetails;

@Component
public interface SenderDetailsDAO {
	
	public SenderDetails findSenderByEmail(String senderEmail);
	public SenderDetails findSenderByPhone(String senderPhone);
	public List<SenderDetails> findAllSenderByFirst(String senderFirst);
	public List<SenderDetails> findAllSenderByLast(String senderLast);
	public SenderDetails saveSender(SenderDetails senderDetails);

}
