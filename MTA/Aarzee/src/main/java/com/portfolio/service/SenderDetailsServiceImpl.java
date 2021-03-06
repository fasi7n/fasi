package com.portfolio.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.dao.SenderDetailsDAO;
import com.portfolio.model.SenderDetails;


@Component
public class SenderDetailsServiceImpl implements SenderDetailsService {

	@Autowired
	private SenderDetailsDAO senderDetailsDAO;
	
	
	@Override
	public SenderDetails findSenderByEmail(String senderEmail) {
		
		return senderDetailsDAO.findSenderByEmail(senderEmail);
	}

	@Override
	public SenderDetails findSenderByPhone(String senderPhone) {
		
		return senderDetailsDAO.findSenderByPhone(senderPhone);
	}

	@Override
	public List<SenderDetails> findAllSenderByFirst(String senderFirst) {

		return senderDetailsDAO.findAllSenderByFirst(senderFirst);
	}

	@Override
	public List<SenderDetails> findAllSenderByLast(String senderLast) {
		
		return senderDetailsDAO.findAllSenderByLast(senderLast);
	}

	@Override
	public SenderDetails saveSender(SenderDetails senderDetails) {
		
		return senderDetailsDAO.saveSender(senderDetails);
	}

	
	
	
}
