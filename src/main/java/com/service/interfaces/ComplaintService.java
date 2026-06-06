package com.service.interfaces;

import java.util.List;

import com.dto.PresidentViewComplaintsResponseDTO;
import com.dto.RegisterComplaintDTO;
import com.dto.UpdateStatusRequestDTO;
import com.dto.ViewComplaintsDTO;
import com.model.Complaints;

public interface ComplaintService {

	public int registerComplaint(RegisterComplaintDTO registerComplaintDTO);
	
	public List<ViewComplaintsDTO> getUnsolvedComplaintsOfResident(int residenceId);
	
	public List<ViewComplaintsDTO> getSolvedComplaintsOfResident(int residenceId);
	
	public List<PresidentViewComplaintsResponseDTO> getAllCompaliantsForPresident();
	
	public ViewComplaintsDTO updateStatus(UpdateStatusRequestDTO statusRequestDTO);
	
}
