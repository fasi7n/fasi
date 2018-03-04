package com.portfolio.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Component
@Entity
public class SenderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SENDER_ID")
	private int sender_id;
	
	@Column(name="FIRSTNAME")
	//@NotEmpty(message = "*Please Enter the Sender Name")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
		
	@Column(name="PRIMARY_PHONE")
	private String primaryPhone;
	
	@Column(name="SECONDARY_PHONE")
	private String secondaryPhone;
	
	@Column(name="SENDER_EMAIL")
	private String senderEmail;
	
	@OneToMany(mappedBy = "senderDetails", cascade = CascadeType.ALL)	
	private List<SenderAddress> senderAddress;
	
	@OneToMany(mappedBy = "senderDetails", cascade = CascadeType.ALL)	
	private List<SenderPhotoID> senderPhotoID;
		
	@OneToMany(mappedBy = "senderDetails", cascade = CascadeType.ALL)
	private List<ReceiverDetails> receivers;	
	
	
	
	

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public List<SenderAddress> getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(List<SenderAddress> senderAddress) {
		this.senderAddress = senderAddress;
	}

	public List<SenderPhotoID> getSenderPhotoID() {
		return senderPhotoID;
	}

	public void setSenderPhotoID(List<SenderPhotoID> senderPhotoID) {
		this.senderPhotoID = senderPhotoID;
	}

	public List<ReceiverDetails> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<ReceiverDetails> receivers) {
		this.receivers = receivers;
	}
	
	
	

}
