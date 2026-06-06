package com.controllers;

import java.io.IOException;

import com.dto.PresidentLoginRequestDTO;
import com.dto.PresidentLoginResponseDTO;
import com.dto.PresidentPersonalDetailsResponseDTO;
import com.service.PresidentServiceImp;
import com.util.RequestMapper;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/presidentLogin")
public class PresidentLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PresidentLoginRequestDTO loginResponseDTO = RequestMapper.mapRequest(PresidentLoginRequestDTO.class, req);
		
		PresidentLoginResponseDTO validatePresident = PresidentServiceImp.getPresidentService().validatePresident(loginResponseDTO);
		
		if(validatePresident.isStatus()) {
			
			PresidentPersonalDetailsResponseDTO personalDetailsResponseDTO = validatePresident.getPersonalDetailsResponseDTO();
			
			HttpSession session = req.getSession();
			session.setAttribute("presidentId", personalDetailsResponseDTO.getPresidentId());
			session.setAttribute("name", personalDetailsResponseDTO.getName());
			
			resp.sendRedirect("viewAllComplaints");
			
		}
		
		else {
			
			req.setAttribute("presidentStatusMessage", validatePresident.getMessage());
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			
			requestDispatcher.forward(req, resp);
			
		}
		
	}
	
}
