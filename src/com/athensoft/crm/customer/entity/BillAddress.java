package com.athensoft.crm.customer.entity;

public class BillAddress extends Address{
	private long billingToId;  // account_id

	public long getBillingToId() {
		return billingToId;
	}

	public void setBillingToId(long billingToId) {
		this.billingToId = billingToId;
	}
}
