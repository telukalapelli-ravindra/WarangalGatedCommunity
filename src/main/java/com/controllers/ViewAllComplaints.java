package com.controllers;

import java.io.IOException;
import java.util.List;

import com.dto.PresidentViewComplaintsResponseDTO;
import com.service.ComplaintServiceImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewAllComplaints")
public class ViewAllComplaints extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<PresidentViewComplaintsResponseDTO> allCompaliantsForPresident = ComplaintServiceImp.geComplaintService().getAllCompaliantsForPresident();
		
		req.setAttribute("allComplaints", allCompaliantsForPresident);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("PresidentHomePage.jsp");
		
		requestDispatcher.forward(req, resp);
		
	}
}
