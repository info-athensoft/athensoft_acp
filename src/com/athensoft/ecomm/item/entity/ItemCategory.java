package com.athensoft.ecomm.item.entity;

public class ItemCategory {
	
	public static final int STATUS_AVAILABLE = 1;
	public static final int STATUS_UNAVAILABLE = 0;

	private long 		categoryId;
	private long 		parentId;
	private String 		categoryName;
	private String 		categoryDesc;
	private String 		categoryCode;
	private int			categoryLevel;
	private int			categoryStatus;
	
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public int getCategoryLevel() {
		return categoryLevel;
	}
	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
	public int getCategoryStatus() {
		return categoryStatus;
	}
	public void setCategoryStatus(int categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	
	@Override
	public String toString() {
		return "ItemCategory [categoryId=" + categoryId + ", parentId=" + parentId + ", categoryName=" + categoryName
				+ ", categoryDesc=" + categoryDesc + ", categoryCode=" + categoryCode + ", categoryLevel="
				+ categoryLevel + ", categoryStatus=" + categoryStatus + "]";
	}
	
	
	
	
}
