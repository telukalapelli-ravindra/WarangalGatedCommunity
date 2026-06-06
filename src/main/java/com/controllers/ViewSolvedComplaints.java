package com.controllers;

import java.io.IOException;
import java.util.List;

import com.dto.ViewComplaintsDTO;
import com.service.ComplaintServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewSolvedComplaints")
public class ViewSolvedComplaints extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		int residenceId=(Integer) session.getAttribute("residenceId");
		
		List<ViewComplaintsDTO> solvedComplaints = ComplaintServiceImp.geComplaintService().getSolvedComplaintsOfResident(residenceId);
		
		req.setAttribute("solvedComplaints", solvedComplaints);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewSolvedComplaints.jsp");
		
		requestDispatcher.forward(req, resp);
		
	}
	
}
