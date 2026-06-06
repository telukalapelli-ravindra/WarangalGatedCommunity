package com.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ResidencePersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int residenceId;
	
	private String name;
	
	private String houseNumber;
	
	private long phoneNumber;
	
	private int age;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "residencePersonalDetails")
	private List<Complaints> complaint;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "loginDetails")
	private ResidenceLoginDetails residenceLoginDetails;
	
	public ResidencePersonalDetails() {
		
	}
	
	
	

	public List<Complaints> getComplaint() {
		return complaint;
	}




	public void setComplaint(List<Complaints> complaint) {
		this.complaint = complaint;
	}




	public ResidencePersonalDetails(String name, String houseNumber, long phoneNumber, int age) {
		super();
		this.name = name;
		this.houseNumber = houseNumber;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}



	public ResidencePersonalDetails(int residenceId, String name, String houseNumber, long phoneNumber, int age,
			ResidenceLoginDetails residenceLoginDetails) {
		super();
		this.residenceId = residenceId;
		this.name = name;
		this.houseNumber = houseNumber;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.residenceLoginDetails = residenceLoginDetails;
	}

	public ResidencePersonalDetails(String name, String houseNumber, long phoneNumber, int age,
			ResidenceLoginDetails residenceLoginDetails) {
		super();
		this.name = name;
		this.houseNumber = houseNumber;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.residenceLoginDetails = residenceLoginDetails;
	}

	public int getResidenceId() {
		return residenceId;
	}

	public void setResidenceId(int residenceId) {
		this.residenceId = residenceId;
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ResidenceLoginDetails getResidenceLoginDetails() {
		return residenceLoginDetails;
	}

	public void setResidenceLoginDetails(ResidenceLoginDetails residenceLoginDetails) {
		this.residenceLoginDetails = residenceLoginDetails;
	}




	@Override
	public String toString() {
		return "ResidencePersonalDetails [residenceId=" + residenceId + ", name=" + name + ", houseNumber="
				+ houseNumber + ", phoneNumber=" + phoneNumber + ", age=" + age + "]";
	}
	
	
	
}
