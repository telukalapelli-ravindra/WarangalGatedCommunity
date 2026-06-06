package com.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Complaints {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintId;
	
	private String category;
	
	private String subject;
	
	private String description;
	
	private String status="Registered";
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "residenceId")
	private ResidencePersonalDetails residencePersonalDetails;
	
	
	

	public Complaints() {
		super();
	}



	public Complaints(String category, String subject, String description, String status,
			ResidencePersonalDetails residencePersonalDetails) {
		super();
		this.category = category;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.residencePersonalDetails = residencePersonalDetails;
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

	public ResidencePersonalDetails getResidencePersonalDetails() {
		return residencePersonalDetails;
	}

	public void setResidencePersonalDetails(ResidencePersonalDetails residencePersonalDetails) {
		this.residencePersonalDetails = residencePersonalDetails;
	}



	@Override
	public String toString() {
		return "Complaints [complaintId=" + complaintId + ", category=" + category + ", subject=" + subject
				+ ", description=" + description + ", status=" + status + ", createdAt=" + createdAt
				+ ", residencePersonalDetails=" + residencePersonalDetails + "]";
	}



	
	
	
	
}
