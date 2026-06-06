package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dao.ComplaintDAO;
import com.dao.ResidenceDao;
import com.dto.PresidentViewComplaintsResponseDTO;
import com.dto.RegisterComplaintDTO;
import com.dto.ResidencePersonalDetailsDTO;
import com.dto.UpdateStatusRequestDTO;
import com.dto.ViewComplaintsDTO;
import com.model.Complaints;
import com.model.ResidencePersonalDetails;
import com.service.interfaces.ComplaintService;
import com.util.RequestMapper;

public class ComplaintServiceImp implements ComplaintService{
	
	//creation of ComplaintService object
	private static ComplaintService complaintService;
	
	private ComplaintServiceImp() {
		
	}
	
	public static ComplaintService geComplaintService() {
		
		if(complaintService==null) {
			
			complaintService=new ComplaintServiceImp();
			
			return complaintService;
		}
		
		return complaintService;
		
	}
	
//----------------------------------------------------------------------------------------------------
	
	
	//Getting ComplaintDAO object to perform operation on Complaint table
	ComplaintDAO dao= ComplaintDAO.getComplaintDAO();
	
	// Creating Logger Object
	
	private static final Logger logger= LoggerFactory.getLogger(ComplaintServiceImp.class);

	
	
	//saving complaint
	@Override
	public int registerComplaint(RegisterComplaintDTO registerComplaintDTO) {
		
		logger.debug("Received RegisteredComplaintDAo from servlet: {}", registerComplaintDTO);
		
		int id = Integer.parseInt(registerComplaintDTO.getResidenceId().trim());
		
		
		ResidencePersonalDetails details=new ResidencePersonalDetails(id, null, null, 0, 0, null);
	
		Complaints complaint = RequestMapper.mapRequest(Complaints.class, registerComplaintDTO);
		
		complaint.setResidencePersonalDetails(details);
		logger.info("ResidenceId is copied:{}",details);
		logger.info("RegisterComplaintDAO fields are copied to Complaint: {}", complaint);
		
		dao.saveComplaint(complaint);
		logger.info("Complaint is saved in DB");
		
		return id;
		
	}

	@Override
	public List<ViewComplaintsDTO> getUnsolvedComplaintsOfResident(int residenceId) {
		
		ResidencePersonalDetails details = ResidenceDao.getResidenceDao().getResudencePersonalDetailsById(residenceId);
		
		List<Complaints> complaints = dao.getComplaints(details);
		
		List<ViewComplaintsDTO> list = complaints.stream()
				.map(complaint -> RequestMapper.mapRequest(ViewComplaintsDTO.class, complaint))
				.filter(complaint -> !complaint.getStatus().equalsIgnoreCase("solved"))
				.toList();
		
		return list;
	}
	
	
	@Override
	public List<ViewComplaintsDTO> getSolvedComplaintsOfResident(int residenceId) {
ResidencePersonalDetails details = ResidenceDao.getResidenceDao().getResudencePersonalDetailsById(residenceId);
		
		List<Complaints> complaints = dao.getComplaints(details);
		
		List<ViewComplaintsDTO> list = complaints.stream()
				.map(complaint -> RequestMapper.mapRequest(ViewComplaintsDTO.class, complaint))
				.filter(complaint -> complaint.getStatus().equalsIgnoreCase("solved"))
				.toList();
		
		return list;
	}

	@Override
	public List<PresidentViewComplaintsResponseDTO> getAllCompaliantsForPresident() {
		
		logger.info("Fetching All Complaints");
		
		List<Complaints> allComplaintList = dao.getAllComplaintList();
		
		
		List<PresidentViewComplaintsResponseDTO> list = allComplaintList.stream()	
						.map(complaint ->
						{
						
							ResidencePersonalDetailsDTO personalDetailsDTO = RequestMapper.mapRequest(ResidencePersonalDetailsDTO.class, complaint.getResidencePersonalDetails());
							
						PresidentViewComplaintsResponseDTO viewComplaintsResponseDTO = RequestMapper.mapRequest(PresidentViewComplaintsResponseDTO.class, complaint);
						
						viewComplaintsResponseDTO.setResidencePersonalDetailsDTO(personalDetailsDTO);
						
						return viewComplaintsResponseDTO;
						
						}
						)
						.toList();
		logger.debug("Fetched all Complaints and copied to List<PresidentViewComplaintsResponseDTO>  :{}", list);
		
		logger.info("Feteched all coplaints");
		
		return list;
	}

	@Override
	public ViewComplaintsDTO updateStatus(UpdateStatusRequestDTO statusRequestDTO) {
		
		logger.info("Updating the Status for ComplaintId: {}", statusRequestDTO.getComplaintId());
		
		
		Complaints complaintById = dao.getComplaintById(statusRequestDTO.getComplaintId());
		
		logger.debug("Complaint is REtrived for ComplaintId: {}", complaintById);
		
		complaintById.setStatus(statusRequestDTO.getStatus());
		
		Complaints updateStatus = dao.updateStatus(complaintById);
		
		logger.info("Status is updated of ComplaintId: {}", statusRequestDTO.getComplaintId());
		
		logger.debug("The updates status Complaint: {}", updateStatus);
		
		ViewComplaintsDTO viewComplaintsDTO = RequestMapper.mapRequest(ViewComplaintsDTO.class, updateStatus);
		
		logger.debug("UpdatedComplaint is copied to DTO:{}", viewComplaintsDTO);
		
		return viewComplaintsDTO;
	}
}
