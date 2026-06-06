package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PresidentLoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int presidentLoginId;
	
	private String emailId;
	
	private String password;
	
	@OneToOne(mappedBy = "presidentLoginDetails" , cascade = CascadeType.ALL)
	private PresidentPersonalDetails presidentPersonalDetails;
	
	
	public PresidentLoginDetails() {
		
	}

	public PresidentLoginDetails(int presidentLoginId, String emailId, String password) {
		super();
		this.presidentLoginId = presidentLoginId;
		this.emailId = emailId;
		this.password = password;
	}

	public PresidentLoginDetails(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	
	
	public PresidentLoginDetails(String emailId, String password,
			PresidentPersonalDetails presidentPersonalDetails) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.presidentPersonalDetails = presidentPersonalDetails;
	}

	public int getPresidentLoginId() {
		return presidentLoginId;
	}

	public void setPresidentLoginId(int presidentLoginId) {
		this.presidentLoginId = presidentLoginId;
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

	

	public PresidentPersonalDetails getPresidentPersonalDetails() {
		return presidentPersonalDetails;
	}

	public void setPresidentPersonalDetails(PresidentPersonalDetails presidentPersonalDetails) {
		this.presidentPersonalDetails = presidentPersonalDetails;
	}

	@Override
	public String toString() {
		return "PresidentLoginDetails [presidentId=" + presidentLoginId + ", emailId=" + emailId + ", password=" + password
				+ "]";
	}
	
	
	
}
