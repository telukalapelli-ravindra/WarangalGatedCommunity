package com.dto;

import java.time.LocalDateTime;


public class ViewComplaintsDTO {
	
	private int complaintId;

	private String category;
	
	private String subject;
	
	private String description;
	
	private String status;
	
	private LocalDateTime createdAt;
	
	public ViewComplaintsDTO() {
		
	}
	
	

	public int getComplaintId() {
		return complaintId;
	}



	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ViewComplaintsDTO [complaintId=" + complaintId + ", category=" + category + ", subject=" + subject
				+ ", description=" + description + ", status=" + status + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
