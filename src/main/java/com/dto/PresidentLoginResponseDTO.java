package com.dto;

public class PresidentLoginResponseDTO {

	private boolean status;
	
	private String message;
	
	private PresidentPersonalDetailsResponseDTO personalDetailsResponseDTO;
	
	public PresidentLoginResponseDTO() {
		
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PresidentPersonalDetailsResponseDTO getPersonalDetailsResponseDTO() {
		return personalDetailsResponseDTO;
	}

	public void setPersonalDetailsResponseDTO(PresidentPersonalDetailsResponseDTO personalDetailsResponseDTO) {
		this.personalDetailsResponseDTO = personalDetailsResponseDTO;
	}

	@Override
	public String toString() {
		return "PresidentLoginResponseDTO [status=" + status + ", message=" + message + ", personalDetailsResponseDTO="
				+ personalDetailsResponseDTO + "]";
	}
	
	
	
}
