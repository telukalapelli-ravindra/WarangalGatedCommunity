package com.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import com.dto.ResidenceLoginDTO;
import com.dto.ResidencePersonalDetailsDTO;
import com.service.ResidenceServiceImp;
import com.service.interfaces.ResidenceService;
import com.util.RequestMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/residenceLogin")
public class ResidenceLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ResidenceLoginDTO loginDTO = RequestMapper.mapRequest(ResidenceLoginDTO.class, req);

		
		ResidenceService residenceService = ResidenceServiceImp.getResidenceService();
		
		ResidencePersonalDetailsDTO validatedLogin = residenceService.validatedLogin(loginDTO);
		
		if(validatedLogin!=null) {
			
				HttpSession session = req.getSession();
				session.setAttribute("residenceId", validatedLogin.getResidenceId());
				session.setAttribute("residenceName", validatedLogin.getName());
				
			resp.sendRedirect("ResidenceHomePage.jsp");
		}
		else {
			
			resp.sendRedirect("login.jsp");
		}
		
	}
	
}
