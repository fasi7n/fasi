package com.portfolio.helperBeans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchTxnBean {
	
	@JsonProperty
	private String selectedInputName;
	@JsonProperty
	private String selectedInputValue;
	
	
	public SearchTxnBean() {}
	
	
	public SearchTxnBean(String searchTxnBean) {
		
	}


	public String getSelectedInputName() {
		return selectedInputName;
	}


	public void setSelectedInputName(String selectedInputName) {
		this.selectedInputName = selectedInputName;
	}


	public String getSelectedInputValue() {
		return selectedInputValue;
	}


	public void setSelectedInputValue(String selectedInputValue) {
		this.selectedInputValue = selectedInputValue;
	}


	

	



	
	
	
	
	

}
