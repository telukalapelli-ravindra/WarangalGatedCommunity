package com.dto;

public class RegisterComplaintDTO {

	private String category;
	
	private String subject;
	
	private String description;
	
	private String residenceId;
	
	public RegisterComplaintDTO() {
		
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResidenceId() {
		return residenceId;
	}

	public void setResidenceId(String residenceId) {
		this.residenceId = residenceId;
	}

	@Override
	public String toString() {
		return "RegisterComplaintDTO [category=" + category + ", subject=" + subject + ", description=" + description
				+ ", residenceId=" + residenceId + "]";
	}
	
	
}
