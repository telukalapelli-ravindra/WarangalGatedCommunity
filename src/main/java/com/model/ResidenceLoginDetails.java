package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ResidenceLoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int residenceLoginId;
	
	private String emailId;
	
	private String password;
	
	@OneToOne(mappedBy = "residenceLoginDetails" , cascade = CascadeType.ALL)
	private ResidencePersonalDetails residencePersonalDetails;
	
	public ResidenceLoginDetails() {
		
	}

	public ResidenceLoginDetails(int residenceLoginId, String emailId, String password) {
		super();
		this.residenceLoginId = residenceLoginId;
		this.emailId = emailId;
		this.password = password;
	}

	
	
	public ResidenceLoginDetails(String emailId, String password, ResidencePersonalDetails residencePersonalDetails) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.residencePersonalDetails = residencePersonalDetails;
	}

	public ResidenceLoginDetails(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public int getResidenceLoginId() {
		return residenceLoginId;
	}

	public void setResidenceLoginId(int residenceLoginId) {
		this.residenceLoginId = residenceLoginId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ResidencePersonalDetails getResidencePersonalDetails() {
		return residencePersonalDetails;
	}

	public void setResidencePersonalDetails(ResidencePersonalDetails residencePersonalDetails) {
		this.residencePersonalDetails = residencePersonalDetails;
	}

	@Override
	public String toString() {
		return "ResidenceLoginDetails [residenceLoginId=" + residenceLoginId + ", emailId=" + emailId + ", password="
				+ password + ", residencePersonalDetails=" + residencePersonalDetails + "]";
	}
	
	
	
	
}
