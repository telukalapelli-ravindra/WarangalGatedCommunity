package com.dto;

public class PresidentLoginRequestDTO {

	private String emailId;
	
	private String password;
	
	public PresidentLoginRequestDTO() {
		
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
		return "PresidentLoginResponseDTO [emailId=" + emailId + ", password=" + password + "]";
	}
	
	
}
