package com.portfolio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TRANSACTION_ID")
	private int transaction_id;
	
	@Column(name="TRANSACTION_DATE")
	@Temporal(TemporalType.DATE)
    private Date date;
	
	@Column(name="TRANSACTION_TIME")
    @Temporal(TemporalType.TIME)
    private Date time;
    
	@Column(name="TRANSACTION_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
	
	@Column(name="SENDER_NAME")    
    private String senderName;
	
	@Column(name="RECEIVER_NAME")    
    private String receiverName;
	
	@Column(name="AMOUNT_SENT")    
    private double amountSent;
	
	@Column(name="EXCHANGE_RATE")    
    private double exchangeRate;
	
	@Column(name="AMOUNT_RECEIVED")    
    private double amountReceived;
	
	@Column(name="RECEIVE_DATE")
    @Temporal(TemporalType.DATE)
    private Date receiveDate;	
	
	@Column(name="RECEIVER_FULLADDRESS")
	private String receiverFullAddress;

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public double getAmountSent() {
		return amountSent;
	}

	public void setAmountSent(double amountSent) {
		this.amountSent = amountSent;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public double getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(double amountReceived) {
		this.amountReceived = amountReceived;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public String getReceiverFullAddress() {
		return receiverFullAddress;
	}

	public void setReceiverFullAddress(String receiverFullAddress) {
		this.receiverFullAddress = receiverFullAddress;
	}
	
	
	
	

}
