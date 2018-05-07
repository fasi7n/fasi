package com.portfolio.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SenderAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private int address_id;
	
	@Column(name="HOME_STREET")
	//@NotEmpty(message = "*Please Enter the Sender Name")
	private String senderHomeStreet;
	
	@Column(name="CITY")
	private String senderCity;
	
	@Column(name="STATE")
	private String senderState;	
		
	@Column(name="ZIP")
	private int senderZip;
	
	@Column(name="COUNTRY")
	private String senderCountry;
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private SenderDetails senderDetails;


	public SenderAddress()
	{}
	
	
	
	
	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	

	public String getSenderHomeStreet() {
		return senderHomeStreet;
	}

	public void setSenderHomeStreet(String senderHomeStreet) {
		this.senderHomeStreet = senderHomeStreet;
	}

	public String getSenderCity() {
		return senderCity;
	}

	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}

	public String getSenderState() {
		return senderState;
	}

	public void setSenderState(String senderState) {
		this.senderState = senderState;
	}

	public int getSenderZip() {
		return senderZip;
	}

	public void setSenderZip(int senderZip) {
		this.senderZip = senderZip;
	}

	public String getSenderCountry() {
		return senderCountry;
	}

	public void setSenderCountry(String senderCountry) {
		this.senderCountry = senderCountry;
	}

	public SenderDetails getSenderDetails() {
		return senderDetails;
	}

	public void setSenderDetails(SenderDetails senderDetails) {
		this.senderDetails = senderDetails;
	}

	
	
	
}
