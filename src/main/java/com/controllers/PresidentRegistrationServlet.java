package com.controllers;


import java.io.IOException;

import com.dto.PresidentDetails;
import com.service.PresidentServiceImp;
import com.util.RequestMapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/presidentRegistration")
public class PresidentRegistrationServlet extends HttpServlet {

	private PresidentServiceImp presidentService=PresidentServiceImp.getPresidentService();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		RequestMapper r=new RequestMapper();
		
		PresidentDetails mapRequest = r.mapRequest(PresidentDetails.class, req);
		
		String savePresident = presidentService.savePresident(mapRequest, req.getParameterMap());
		
		if(savePresident!=null) {
			req.setAttribute("saved", savePresident);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
			
		}
		else {
			
			resp.sendRedirect("PresidentRegister.jsp");
		}
		
		
	}
	
}
