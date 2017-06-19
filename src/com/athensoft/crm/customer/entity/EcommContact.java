package com.athensoft.crm.customer.entity;

public class EcommContact {
	private long contactId;
	
	private String contactNo;
	
	private int contactStatus;
	
	private long customerId;	//FK
	
	//private String billtoName;	//entity_name
	
	private String email;
	
	private String telNum;
	
	private String cellNum;
	
	private String faxNum;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getContactStatus() {
		return contactStatus;
	}

	public void setContactStatus(int contactStatus) {
		this.contactStatus = contactStatus;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getCellNum() {
		return cellNum;
	}

	public void setCellNum(String cellNum) {
		this.cellNum = cellNum;
	}

	public String getFaxNum() {
		return faxNum;
	}

	public void setFaxNum(String faxNum) {
		this.faxNum = faxNum;
	}
}
