package com.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReceiverAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private int address_id;
	
	@Column(name="HOME_STREET")
	//@NotEmpty(message = "*Please Enter the Sender Name")
	private String homeStreet;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;	
		
	@Column(name="ZIP")
	private int zip;
	
	@Column(name="COUNTRY")
	private String country;
	
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private ReceiverDetails receiverDetails;

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getHomeStreet() {
		return homeStreet;
	}

	public void setHomeStreet(String homeStreet) {
		this.homeStreet = homeStreet;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ReceiverDetails getReceiverDetails() {
		return receiverDetails;
	}

	public void setReceiverDetails(ReceiverDetails receiverDetails) {
		this.receiverDetails = receiverDetails;
	}
	
	
	

}
