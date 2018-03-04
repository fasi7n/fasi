package com.portfolio.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.model.SenderDetails;
import com.portfolio.repositories.SenderDetailsRepository;

public class SenderDetailsDAOImpl implements SenderDetailsDAO {
	
	@Autowired
	private SenderDetailsRepository senderDetailsRepository;

	@Override
	public SenderDetails findSenderByEmail(String senderEmail) {		
		return senderDetailsRepository.findBySenderEmail(senderEmail);		
	}

	@Override
	public SenderDetails findSenderByPhone(String senderPhone) {
		return senderDetailsRepository.findByPrimaryPhone(senderPhone);
	}

	@Override
	public List<SenderDetails> findAllSenderByFirst(String senderFirst) {
		return senderDetailsRepository.findByFirstName(senderFirst);
	}

	@Override
	public List<SenderDetails> findAllSenderByLast(String senderLast) {
		return senderDetailsRepository.findByLastName(senderLast);
	}

	@Override
	public SenderDetails saveSender(SenderDetails senderDetails) {
		return senderDetailsRepository.save(senderDetails);		
	}
	
}
