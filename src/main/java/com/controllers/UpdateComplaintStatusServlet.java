package com.controllers;

import java.io.IOException;

import com.dto.UpdateStatusRequestDTO;
import com.dto.ViewComplaintsDTO;
import com.service.ComplaintServiceImp;
import com.util.RequestMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateComplaintStatus")
public class UpdateComplaintStatusServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String parameter = req.getParameter("status");
		System.out.println(parameter);
		System.out.println(req.getParameter("complaintId"));
		
		UpdateStatusRequestDTO statusRequestDTO = RequestMapper.mapRequest(UpdateStatusRequestDTO.class, req);
		
		ViewComplaintsDTO updateStatus = ComplaintServiceImp.geComplaintService().updateStatus(statusRequestDTO);
		
		resp.sendRedirect("viewAllComplaints");
		
	}
	
}
