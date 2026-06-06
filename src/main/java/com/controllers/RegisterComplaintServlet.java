package com.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import com.dto.RegisterComplaintDTO;
import com.service.ComplaintServiceImp;
import com.service.ResidenceServiceImp;
import com.service.interfaces.ComplaintService;
import com.service.interfaces.ResidenceService;
import com.util.RequestMapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerComplaint")
public class RegisterComplaintServlet  extends HttpServlet{

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 RegisterComplaintDTO registerComplaintDTO = RequestMapper.mapRequest(RegisterComplaintDTO.class, req);
		

		ComplaintService complaintService = ComplaintServiceImp.geComplaintService();
		
		int savedResidenceId = complaintService.registerComplaint(registerComplaintDTO);
		
		req.setAttribute("residenceId", savedResidenceId);
		
		 resp.sendRedirect("viewUnSolvedComplaints");
		 
		 
	}
}
