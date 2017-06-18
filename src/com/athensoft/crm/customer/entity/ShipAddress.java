package com.athensoft.crm.customer.entity;

public class ShipAddress extends Address{
	private long shippingToId;  // account_id

	public long getShippingToId() {
		return shippingToId;
	}

	public void setShippingToId(long shippingToId) {
		this.shippingToId = shippingToId;
	}
}
