package com.portfolio;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.portfolio.commons.SimpleSHADigest;
import com.portfolio.model.ReceiverAddress;
import com.portfolio.model.ReceiverDetails;
import com.portfolio.model.SenderAddress;
import com.portfolio.model.SenderDetails;
import com.portfolio.model.SenderPhotoID;
import com.portfolio.model.UserCredentials;
import com.portfolio.model.UserDetails;
import com.portfolio.model.UserRoles;
import com.portfolio.service.SenderDetailsService;
import com.portfolio.service.SenderDetailsServiceImpl;
import com.portfolio.service.UserCredentialsService;
import com.portfolio.service.UserDetailsService;
import com.portfolio.service.UserRolesService;



@Component
public class LoadDummyContent {
	
	@Autowired
	private UserCredentials userCredentials;
	
	@Autowired
	private UserDetails userDetails;
	
	@Autowired
	private UserRoles userRole;
	
	@Autowired
	private UserCredentialsService userCredService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserRolesService userRolesService;
	
	@Autowired
	private LoadDummyContent loadDummyContent;
	
	@Autowired
	private SenderDetails senderDetails;
	
	@Autowired
	private SenderDetailsService senderDetailsService;
	
	@Autowired
	private SenderAddress senderAddress;
	
	@Autowired
	private SenderPhotoID senderPhotoID;
	
	@Autowired
	private ReceiverDetails receiverDetails;
	
	@Autowired
	private ReceiverAddress receiverAddress;
	
	
	public void loadDummyData(){
		
		loadDummyContent.loadUser();
		loadDummyContent.loadSender();

		
	}

	
	private void loadUser(){
		
		userCredentials.setEmail_ID("fasi@fasi.com");
		userCredentials.setPassword(SimpleSHADigest.mySha1("Fasi123!#"));
		
		userDetails.setEmail_ID("fasi@fasi.com");
		userDetails.setFirstname("Fasi");
		userDetails.setLastname("Uddin");
		userDetails.setPhone("123-456-7890");
		
		userRole.setEmail_ID("fasi@fasi.com");
		userRole.setRolename("ADMIN");
		
		String actionResult1 = userCredService.createUserByEmail(userCredentials);
		String actionResult2 = userDetailsService.createUserDetailsByEmail(userDetails);
		String actionResult3 = userRolesService.createUserRolesByEmail(userRole);
		
		if(actionResult1.equalsIgnoreCase("success") && actionResult2.equalsIgnoreCase("success") && actionResult3.equalsIgnoreCase("success"))
		System.out.println("Dummy user created with email = " + userCredentials.getEmail_ID() + " and password = Fasi123!#");
		System.out.println("Dummy user Details created with First Name: " + userDetails.getFirstname() + " Last name: " + userDetails.getLastname() + " Phone: " + userDetails.getPhone());
		System.out.println("Dummy user ROLE created with Role Name: " + userRole.getRolename());
	}
	
	
private void loadSender(){
		
	senderDetails.setFirstName("Fasi");
	senderDetails.setLastName("Uddin");
	senderDetails.setPrimaryPhone("1234567890");
	senderDetails.setSecondaryPhone("0987654321");
	senderDetails.setSenderEmail("fasi@fasi.com");
	
	
	senderAddress.setSenderHomeStreet("3 Green Tree Stree");
	senderAddress.setSenderCity("Treat City");
	senderAddress.setSenderState("Great State");
	senderAddress.setSenderCountry("Greater Country");
	senderAddress.setSenderZip(55555);
	
	List<SenderAddress> senderAddressList = new ArrayList<>();
	senderAddressList.add(senderAddress);
	
	senderDetails.setSenderAddress(senderAddressList);
	
	
	senderPhotoID.setIdNo("A123-B456-C789");
	senderPhotoID.setIdType("Driver's License");
	try
	{
	LocalDate dobDate = LocalDate.parse("01-Jan-1900", DateTimeFormatter.ofPattern("d-MMM-yyyy"));
	senderPhotoID.setDob(dobDate);
	LocalDate issueDate = LocalDate.parse("01-Jan-2000", DateTimeFormatter.ofPattern("d-MMM-yyyy"));
	senderPhotoID.setIssueDate(issueDate);
	LocalDate expiryDate = LocalDate.parse("01-Jan-3000", DateTimeFormatter.ofPattern("d-MMM-yyyy"));
	senderPhotoID.setIssueDate(expiryDate);
	}
	catch(DateTimeParseException dtpe)
	{
		System.out.println("DT PARSE EXCP ----> ");
		dtpe.printStackTrace();
	}
	catch(DateTimeException dte)
	{
		dte.printStackTrace();
	}
	

	
	List<SenderPhotoID> senderPhotoIDs =  new ArrayList<>();
	senderPhotoIDs.add(senderPhotoID);
	
	senderDetails.setSenderPhotoID(senderPhotoIDs);
	
	
	receiverDetails.setFirstName("Vika");
	receiverDetails.setLastName("Chu");
	receiverDetails.setPrimaryPhone("1112223333");
	receiverDetails.setSecondaryPhone("3332221111");
	receiverDetails.setReceiverEmail("vika@chu.com");
	
	receiverAddress.setReceiverHomeStreet("7 Heaven Driven");
	receiverAddress.setReceiverCity("Pretty City");
	receiverAddress.setReceiverState("Tweety State");
	receiverAddress.setReceiverCountry("Fruity Country");
	
	List<ReceiverAddress> receiverAddresses = new ArrayList<>();
	receiverAddresses.add(receiverAddress);
	
	receiverDetails.setReceiverAddress(receiverAddresses);
	
	List<ReceiverDetails> receivers = new ArrayList<>();
	receivers.add(receiverDetails);
	
	senderDetails.setReceivers(receivers);
	
	senderDetailsService.saveSender(senderDetails);
	

	}
	
	
	
}
