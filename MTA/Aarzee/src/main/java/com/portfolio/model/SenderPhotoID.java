package com.portfolio.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SenderPhotoID {
	
	@Id
	@Column(name="ID_NO")
	private String idNo;
	
	@Column(name="ID_TYPE")
	//@NotEmpty(message = "*Please Enter the Sender Name")
	private String idType;
	
	@Column(name="DOB")
	private LocalDate dob;			
	
	@Column(name="ISSUED")
	private LocalDate issueDate;
	
	@Column(name="EXPIRES")
	private LocalDate expiryDate;
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private SenderDetails senderDetails;


	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public SenderDetails getSenderDetails() {
		return senderDetails;
	}

	public void setSenderDetails(SenderDetails senderDetails) {
		this.senderDetails = senderDetails;
	}

	
	
	
}
