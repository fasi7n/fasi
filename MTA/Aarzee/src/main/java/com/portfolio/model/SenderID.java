package com.portfolio.model;

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

@Entity
public class SenderID {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SENDER_ID_NO")
	private int sender_id_no;
	
	@Column(name="ID_TYPE")
	//@NotEmpty(message = "*Please Enter the Sender Name")
	private String idType;
	
	@Column(name="ID_NO")
	private String idNo;
	
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;			
	
	@Column(name="ISSUED")
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	
	@Column(name="EXPIRES")
	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private SenderDetails senderDetails;

	public int getSender_id_no() {
		return sender_id_no;
	}

	public void setSender_id_no(int sender_id_no) {
		this.sender_id_no = sender_id_no;
	}

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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public SenderDetails getSenderDetails() {
		return senderDetails;
	}

	public void setSenderDetails(SenderDetails senderDetails) {
		this.senderDetails = senderDetails;
	}

	
	
	
}
