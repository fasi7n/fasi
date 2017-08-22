package com.portfolio.helperBeans;

import org.springframework.stereotype.Component;

@Component
public class SenderFormBean {
	
	private String senderFirst;
	private String senderLast;
	private String senderPhone;
	private String senderEmail;
	
	
	
	public String getSenderFirst() {
		return senderFirst;
	}
	public void setSenderFirst(String senderFirst) {
		this.senderFirst = senderFirst;
	}
	public String getSenderLast() {
		return senderLast;
	}
	public void setSenderLast(String senderLast) {
		this.senderLast = senderLast;
	}
	public String getSenderPhone() {
		return senderPhone;
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	
	

}
