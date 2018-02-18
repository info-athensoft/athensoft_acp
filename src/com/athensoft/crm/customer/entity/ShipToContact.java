package com.athensoft.crm.customer.entity;

public class ShipToContact extends EcommContact{
	
	private String shiptoName;
	
	private ShipToAddress shiptoAddr;

	public String getShiptoName() {
		return shiptoName;
	}

	public void setShiptoName(String shiptoName) {
		this.shiptoName = shiptoName;
	}

	public ShipToAddress getShiptoAddr() {
		return shiptoAddr;
	}

	public void setShiptoAddr(ShipToAddress shiptoAddr) {
		this.shiptoAddr = shiptoAddr;
	}

	
	
}
