package com.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.PresidentDao;
import com.dto.PresidentDetails;
import com.dto.PresidentLoginRequestDTO;
import com.dto.PresidentLoginResponseDTO;
import com.dto.PresidentPersonalDetailsResponseDTO;
import com.dto.ResidenceLoginDTO;
import com.model.PresidentLoginDetails;
import com.model.PresidentPersonalDetails;
import com.service.interfaces.PresidentService;
import com.util.RequestMapper;

import jakarta.servlet.http.HttpServletRequest;


public class PresidentServiceImp  implements PresidentService{

	//PresidentService Object Creation to follow Singleton principle
	private static PresidentServiceImp presidentService;
	
	private PresidentServiceImp() {
		
	}
	
	public static PresidentServiceImp getPresidentService() {
		
		if(presidentService==null) {
			
			presidentService=new PresidentServiceImp();
			
			return presidentService;
			
		}
		
		return presidentService;
	}
	
	
	//Calling President Registet object
	private PresidentDao presidentDao=PresidentDao.getPresidentDao();
	
	
	//Creating Logger
	
	private static final Logger logger=LoggerFactory.getLogger(PresidentServiceImp.class);
	
	
	//Saving President details into DB
	@Override
	public String savePresident(PresidentDetails presidentDetails, Map<String, String[]> getParameters) {
		 
		RequestMapper r=new RequestMapper();
		PresidentLoginDetails presidentLoginDetails = r.mapRequest(PresidentLoginDetails.class, getParameters);
		PresidentPersonalDetails presidentPersonalDetails = r.mapRequest(PresidentPersonalDetails.class, getParameters);
		
		presidentPersonalDetails.setPresidentLoginDetails(presidentLoginDetails);
		
		presidentDao.save(presidentPersonalDetails);
		
		return "saved";
	}

	@Override
	public PresidentLoginResponseDTO validatePresident(PresidentLoginRequestDTO loginRequestDTO) {
		
		logger.info("Validating President");
		
		
		List<PresidentLoginDetails> loginDetails = presidentDao.findLoginDetailsByEmail(loginRequestDTO.getEmailId());
		
		PresidentLoginResponseDTO responseDTO=new PresidentLoginResponseDTO();
		
		if(!loginDetails.isEmpty())
		{
			
			if(loginDetails.get(0).getPassword().equals(loginRequestDTO.getPassword())) {
				
				logger.info("The president credentials are valid");
				
				PresidentPersonalDetails personalDetails = presidentDao.findByLoginDetails(loginDetails.get(0));
				logger.debug("Fetched President Personal Details: {} using logindeataisl", personalDetails);
				
				PresidentPersonalDetailsResponseDTO personalDetailsResponseDTO=RequestMapper.mapRequest(PresidentPersonalDetailsResponseDTO.class, personalDetails);
				logger.debug("Personal details copied to DTO:{}",personalDetailsResponseDTO);				
				
				responseDTO.setMessage("Credential are valid");
				responseDTO.setStatus(true);
				responseDTO.setPersonalDetailsResponseDTO(personalDetailsResponseDTO);
				
				return responseDTO;
				
				
			}
			
			else {
				
				logger.warn("Incorrect password");
				
				responseDTO.setStatus(false);
				responseDTO.setMessage("Invalid Credentials");
				
				return responseDTO;
				
			}
			
		}
		
		logger.warn("Invalid EmailId enter by President: {}", loginRequestDTO);
		
		responseDTO.setStatus(false);
		responseDTO.setMessage("Invalid Credentaials");
		
		return responseDTO;
	}
	
}
