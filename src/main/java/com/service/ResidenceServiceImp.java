package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.ResidenceDao;
import com.dto.ResidenceLoginDTO;
import com.dto.ResidencePersonalDetailsDTO;
import com.model.ResidenceLoginDetails;
import com.model.ResidencePersonalDetails;
import com.service.interfaces.ResidenceService;
import com.sun.net.httpserver.Request;
import com.util.RequestMapper;


public class ResidenceServiceImp  implements ResidenceService{
	
	// ResidenceLoginService Object creation to follow to Singleton Principle
	
	private static ResidenceService residenceService;
	
	private ResidenceServiceImp() {
		
	}
	
	//Method create object 
	public static ResidenceService getResidenceService() {
		
		if(residenceService==null) {
			
		 	residenceService=new ResidenceServiceImp();
		 	
		 	return residenceService;
		}
		
		return residenceService;
		
	}
	
	//creating Logger 
	 private static final Logger logger =
	            LoggerFactory.getLogger(
	                    ResidenceServiceImp.class);
	

	
	//Getting ResidenceDAO object
	private ResidenceDao residenceDao=ResidenceDao.getResidenceDao();
	
	@Override
	public void saveResidence(ResidencePersonalDetails residenceLoginDetails) {
		
		residenceDao.save(residenceLoginDetails);
		
	}

	@Override
	public ResidencePersonalDetailsDTO validatedLogin(ResidenceLoginDTO residenceLoginDTO) {
		
		logger.info("Login validation is initiated for email: {}",residenceLoginDTO.getEmailId());
		
		ResidenceLoginDetails loginDetails = RequestMapper.mapRequest(ResidenceLoginDetails.class, residenceLoginDTO);
	
		logger.debug("DTO is mapped to ResidenceLoginDetails");
		
		List<ResidenceLoginDetails> validate = residenceDao.validateResidenceLogin(loginDetails.getEmailId(), loginDetails.getPassword());
		
		logger.debug("DAO return ResidenceLoginDetails {} matching Record", validate.size());
		
		if(!validate.isEmpty()) {
			
			logger.info("Login Successful for email: {}", loginDetails.getEmailId());
			
			 ResidencePersonalDetails residenceDetailsByLoginid = residenceDao.getResidenceDetailsByLoginid(validate.get(0).getResidenceLoginId());
			
			 ResidencePersonalDetailsDTO detailsDTO = RequestMapper.mapRequest(ResidencePersonalDetailsDTO.class, residenceDetailsByLoginid);
			 logger.debug("Returned the ResidencePersonalDetailDTO: {}",detailsDTO);
			 
			return  detailsDTO;
			
		}
		
		logger.warn("Login failed for emailId: {}", loginDetails.getEmailId());

		return  null;
		
	}
	
	
	
	public ResidencePersonalDetailsDTO getResidenceDetails(int loginId) {
		
		logger.info("Fetching ResidenceDeatails using loginId: {}",loginId);
		
		
		ResidencePersonalDetails residenceDetailsByLoginid = residenceDao.getResidenceDetailsByLoginid(loginId);
		logger.debug("Retrieved ResidenceDetails: {}", residenceDetailsByLoginid);
		
		ResidencePersonalDetailsDTO personalDetailsDTO=null;
		
		if(residenceDetailsByLoginid!=null) {
			
		personalDetailsDTO = RequestMapper.mapRequest(ResidencePersonalDetailsDTO.class, residenceDetailsByLoginid);
			
			logger.debug("Personal Details copied to DTO: {}",personalDetailsDTO);
			
			logger.info("Residence Details found for loginId: {}",loginId);
			
		}
		
		else {
			
			logger.warn("Residence details not found for loginId: {}",loginId);
			
		}
		
		
		return personalDetailsDTO;
	}

	@Override
	public ResidencePersonalDetailsDTO getResidencePersonalDetailsById(int residenceId) {
		
		logger.info("Fteching ResidencePersonalDeatils for residenceId: {}", residenceId);
		
		 ResidencePersonalDetails detailsById = residenceDao.getResudencePersonalDetailsById(residenceId);
		 logger.debug("Retrievied ResidencePersonalDetails:{} ",detailsById);
		 
		 logger.info("Fetched ResidencePersonalDetails for id:{}",residenceId);
		 
		 ResidencePersonalDetailsDTO detailsDTO = RequestMapper.mapRequest(ResidencePersonalDetailsDTO.class, detailsById);
		 logger.debug("Deatils copied to DTO:{} ",detailsDTO);
		 
		 return detailsDTO;
		 
			}
	
	
	
}
