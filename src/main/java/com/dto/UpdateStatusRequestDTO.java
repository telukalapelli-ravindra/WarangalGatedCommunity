package com.dto;

public class UpdateStatusRequestDTO {

	private int complaintId;
	
	private String status;
	
	public UpdateStatusRequestDTO() {
		
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UpdateStatusRequestDTO [complaintId=" + complaintId + ", status=" + status + "]";
	}

	
}
