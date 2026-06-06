package com.controllers;

import java.io.IOException;

import com.dto.ResidencePersonalDetailsDTO;

import com.service.ResidenceServiceImp;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/raiseComplaint")
public class RaiseComplaint extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		HttpSession session = req.getSession();
		
		int residenceId =(Integer) session.getAttribute("residenceId");
		
		ResidencePersonalDetailsDTO residenceDetails = ResidenceServiceImp.getResidenceService().getResidencePersonalDetailsById(residenceId);
		
		System.out.println(residenceDetails);
		
		req.setAttribute("residence", residenceDetails);
	
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("RaiseComplaint.jsp");
		
		requestDispatcher.forward(req, resp);
		
	}

}
