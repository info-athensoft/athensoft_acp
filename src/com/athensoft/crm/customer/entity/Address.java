package com.athensoft.crm.customer.entity;

public class Address {
	private long addressId;
	
	private String streeNum;
	private String streeName;
	private int roomType;
	private String roomNum;
	private String districtCode;
	private String cityCode;
	private String provinceCode;
	private String postalCode;
	private String countryCode;	
	private int addressStatus;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreeNum() {
		return streeNum;
	}

	public void setStreeNum(String streeNum) {
		this.streeNum = streeNum;
	}

	public String getStreeName() {
		return streeName;
	}

	public void setStreeName(String streeName) {
		this.streeName = streeName;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getAddressStatus() {
		return addressStatus;
	}

	public void setAddressStatus(int addressStatus) {
		this.addressStatus = addressStatus;
	}
	
	
	
}
