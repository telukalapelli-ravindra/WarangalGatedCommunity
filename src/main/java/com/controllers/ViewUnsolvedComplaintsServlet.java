package com.controllers;

import java.io.IOException;
import java.util.List;

import com.dto.ViewComplaintsDTO;
import com.model.Complaints;
import com.service.ComplaintServiceImp;
import com.util.RequestMapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewUnSolvedComplaints")
public class ViewUnsolvedComplaintsServlet extends HttpServlet{

	


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		int residenceId = (Integer)session.getAttribute("residenceId");
            
            List<ViewComplaintsDTO> complaints = ComplaintServiceImp.geComplaintService().getUnsolvedComplaintsOfResident(residenceId);
		
           
           
           req.setAttribute("complaints", complaints);
            
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewComplaints.jsp");
            
            requestDispatcher.forward(req, resp);
		
	}
	
}
