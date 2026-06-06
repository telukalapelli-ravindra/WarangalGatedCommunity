package com.dto;

public class ResidencePersonalDetailsDTO {

	private int residenceId;
	
	private String name;
	
	private String houseNumber;
	
	private long phoneNumber;
	
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ResidencePersonalDetailsDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	

	public int getResidenceId() {
		return residenceId;
	}

	public void setResidenceId(int residenceId) {
		this.residenceId = residenceId;
	}

	@Override
	public String toString() {
		return "ResidencePersonalDetailsDTO [residenceId=" + residenceId + ", name=" + name + ", houseNumber="
				+ houseNumber + "]";
	}

	
	
	
}
