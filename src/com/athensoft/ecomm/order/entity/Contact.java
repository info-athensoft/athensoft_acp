package com.athensoft.ecomm.order.entity;

public class Contact {
	private long contactorId;
	private String contactorNo;
	private String entityName;		//individual or business
	private String email;
	private String telNum;
	private String cellNum;
	private String faxNum;
	private int contactStatus;
	
	
	public long getContactorId() {
		return contactorId;
	}
	public void setContactorId(long contactorId) {
		this.contactorId = contactorId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
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
	public String getContactorNo() {
		return contactorNo;
	}
	public void setContactorNo(String contactorNo) {
		this.contactorNo = contactorNo;
	}
	public int getContactStatus() {
		return contactStatus;
	}
	public void setContactStatus(int contactStatus) {
		this.contactStatus = contactStatus;
	}
	@Override
	public String toString() {
		return "Contact [contactorId=" + contactorId + ", contactorNo=" + contactorNo + ", entityName=" + entityName
				+ ", email=" + email + ", telNum=" + telNum + ", faxNum=" + faxNum + ", contactStatus=" + contactStatus
				+ "]";
	}
	
	
	
}
