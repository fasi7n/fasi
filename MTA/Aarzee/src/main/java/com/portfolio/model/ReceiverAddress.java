package com.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class ReceiverAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private int address_id;
	
	@Column(name="HOME_STREET")
	//@NotEmpty(message = "*Please Enter the Sender Name")
	private String receiverHomeStreet;
	
	@Column(name="CITY")
	private String receiverCity;
	
	@Column(name="STATE")
	private String receiverState;	
		
	@Column(name="ZIP")
	private int receiverZip;
	
	@Column(name="COUNTRY")
	private String receiverCountry;
	
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private ReceiverDetails receiverDetails;

	
	public ReceiverAddress()
	{
		
	}
	
	
	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getReceiverHomeStreet() {
		return receiverHomeStreet;
	}

	public void setReceiverHomeStreet(String receiverHomeStreet) {
		this.receiverHomeStreet = receiverHomeStreet;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverState() {
		return receiverState;
	}

	public void setReceiverState(String receiverState) {
		this.receiverState = receiverState;
	}

	public int getReceiverZip() {
		return receiverZip;
	}

	public void setReceiverZip(int receiverZip) {
		this.receiverZip = receiverZip;
	}

	public String getReceiverCountry() {
		return receiverCountry;
	}

	public void setReceiverCountry(String receiverCountry) {
		this.receiverCountry = receiverCountry;
	}

	public ReceiverDetails getReceiverDetails() {
		return receiverDetails;
	}

	public void setReceiverDetails(ReceiverDetails receiverDetails) {
		this.receiverDetails = receiverDetails;
	}

	
	
	

}
