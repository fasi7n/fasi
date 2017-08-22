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
public class ReceiverDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RECEIVER_ID")
	private int receiver_id;
	
	@Column(name="FIRSTNAME")
	//@NotEmpty(message = "*Please Enter the Sender Name")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
		
	@Column(name="PRIMARY_PHONE")
	private String PrimaryPhone;
	
	@Column(name="SECONDARY_PHONE")
	private String SecondaryPhone;
	
	@Column(name="RECEIVER_EMAIL")
	private String receiverEmail;
	
	@ManyToOne
	//@JoinColumn(name = "sender_id")
	private SenderDetails senderDetails;
	
	@OneToMany(mappedBy = "receiverDetails", cascade = CascadeType.ALL)
	//@JoinColumn(name = "receiver_id")
	private Set<ReceiverAddress> receiverAddress;
	
	
	

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
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

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public SenderDetails getSenderDetails() {
		return senderDetails;
	}

	public void setSenderDetails(SenderDetails senderDetails) {
		this.senderDetails = senderDetails;
	}

	public Set<ReceiverAddress> getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(Set<ReceiverAddress> receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	
	
	

}
