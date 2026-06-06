package com.service.interfaces;

import com.dto.ResidenceLoginDTO;
import com.dto.ResidencePersonalDetailsDTO;
import com.model.ResidencePersonalDetails;

public interface ResidenceService {
	
	public void saveResidence(ResidencePersonalDetails residenceLoginDetails);

	public ResidencePersonalDetailsDTO validatedLogin(ResidenceLoginDTO residenceLoginDTO);
	
	public ResidencePersonalDetailsDTO getResidenceDetails(int loginId) ;
	
	public ResidencePersonalDetailsDTO getResidencePersonalDetailsById(int residenceId);
}
