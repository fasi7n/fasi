package com.portfolio.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.portfolio.model.SenderDetails;


@org.springframework.stereotype.Repository
public interface SenderDetailsRepository extends Repository<SenderDetails, Integer> {
	
	SenderDetails findBySenderEmail(String senderEmail);
	SenderDetails findByPrimaryPhone(String senderPhone);
	List<SenderDetails> findByFirstName(String firstName);
	List<SenderDetails> findByLastName(String lastName);
	
	SenderDetails save(SenderDetails senderDetails);
}
