package com.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.model.ResidencePersonalDetails;


public class PresidentViewComplaintsResponseDTO {
	
	private int complaintId;

	private String category;
	
	private String subject;
	
	private String description;
	
	private String status="Registered";
	

	private LocalDateTime createdAt;

	private ResidencePersonalDetailsDTO residencePersonalDetailsDTO;
	
	public PresidentViewComplaintsResponseDTO() {
		
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

	public ResidencePersonalDetailsDTO getResidencePersonalDetailsDTO() {
		return residencePersonalDetailsDTO;
	}

	public void setResidencePersonalDetailsDTO(ResidencePersonalDetailsDTO residencePersonalDetailsDTO) {
		this.residencePersonalDetailsDTO = residencePersonalDetailsDTO;
	}

	@Override
	public String toString() {
		return "PresidentViewComplaintsResponseDTO [category=" + category + ", subject=" + subject + ", description="
				+ description + ", status=" + status + ", createdAt=" + createdAt + ", residencePersonalDetailsDTO="
				+ residencePersonalDetailsDTO + "]";
	}
	
	
	
}
