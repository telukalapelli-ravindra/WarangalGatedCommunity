package com.dto;

public class ResidenceLoginDTO {

	private String emailId;
	
	private String password;

	public ResidenceLoginDTO() {
		super();
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

	@Override
	public String toString() {
		return "ResidenceLoginDTO [emailId=" + emailId + ", password=" + password + "]";
	}
	
	
}
