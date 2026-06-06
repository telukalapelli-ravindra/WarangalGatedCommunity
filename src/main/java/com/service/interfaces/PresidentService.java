package com.service.interfaces;

import java.util.Map;

import com.dto.PresidentDetails;
import com.dto.PresidentLoginRequestDTO;
import com.dto.PresidentLoginResponseDTO;
import com.dto.PresidentPersonalDetailsResponseDTO;
import com.dto.ResidenceLoginDTO;

import jakarta.servlet.http.HttpServletRequest;

public interface PresidentService {

	public String savePresident(PresidentDetails presidentDetails, Map<String,String[]> getParamater);
	
	public PresidentLoginResponseDTO validatePresident(PresidentLoginRequestDTO loginRequestDTO);
	
}
