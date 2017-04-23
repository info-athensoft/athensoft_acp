package com.athensoft.ecomm.order.entity;

public class OrderItem {
	
	private long orderItemId;		//auto-generated
	private int seqNo;				//display sequence no.
	
	private long itemId;
	private String itemName;
	private String itemDesc;
	private double quantity;
	private String unit;
	private double unitPrice;
	private double amount;
	
	private String orderNo;			//FK
	
	
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", seqNo=" + seqNo + ", itemId=" + itemId + ", itemName="
				+ itemName + ", itemDesc=" + itemDesc + ", quantity=" + quantity + ", unit=" + unit + ", unitPrice="
				+ unitPrice + ", amount=" + amount + ", orderNo=" + orderNo + "]";
	}
	
	
	
	
}
