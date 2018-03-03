package com.portfolio.model;

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
	private String PrimaryPhone;
	
	@Column(name="SECONDARY_PHONE")
	private String SecondaryPhone;
	
	@Column(name="SENDER_EMAIL")
	private String senderEmail;
	
	@OneToMany(mappedBy = "senderDetails", cascade = CascadeType.ALL)	
	private Set<SenderAddress> senderAddress;
	
	@OneToMany(mappedBy = "senderDetails", cascade = CascadeType.ALL)	
	private Set<SenderID> senderID;
		
	@OneToMany(mappedBy = "senderDetails", cascade = CascadeType.ALL)
	private Set<ReceiverDetails> receivers;	
	
	
	
	

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
		return PrimaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		PrimaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return SecondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		SecondaryPhone = secondaryPhone;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public Set<SenderAddress> getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(Set<SenderAddress> senderAddress) {
		this.senderAddress = senderAddress;
	}

	public Set<SenderID> getSenderID() {
		return senderID;
	}

	public void setSenderID(Set<SenderID> senderID) {
		this.senderID = senderID;
	}

	public Set<ReceiverDetails> getReceivers() {
		return receivers;
	}

	public void setReceivers(Set<ReceiverDetails> receivers) {
		this.receivers = receivers;
	}
	
	
	

}
