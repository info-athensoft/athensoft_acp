package com.athensoft.crm.customer.entity;

public class BillToContact extends EcommContact{
	
	private String billtoName;
	
	private BillToAddress billtoAddr;

	public String getBilltoName() {
		return billtoName;
	}

	public void setBilltoName(String billtoName) {
		this.billtoName = billtoName;
	}

	public BillToAddress getBilltoAddr() {
		return billtoAddr;
	}

	public void setBilltoAddr(BillToAddress billtoAddr) {
		this.billtoAddr = billtoAddr;
	}
	
}
