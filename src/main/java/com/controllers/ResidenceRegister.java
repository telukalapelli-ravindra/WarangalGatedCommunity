package com.controllers;

import java.io.IOException;

import com.model.ResidenceLoginDetails;
import com.model.ResidencePersonalDetails;
import com.service.ResidenceServiceImp;
import com.service.interfaces.ResidenceService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/residenceRegister")
public class ResidenceRegister extends HttpServlet {



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Enter servlet");
		String name = req.getParameter("name");
		String houseNumber = req.getParameter("houseNumber");
		long phoneNumber = Long.parseLong(req.getParameter("phoneNumber"));
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ResidenceLoginDetails login=new ResidenceLoginDetails(email, password);
		ResidencePersonalDetails details=new ResidencePersonalDetails(name, houseNumber, phoneNumber, age,login);
		
		
		ResidenceService residenceService = ResidenceServiceImp.getResidenceService();
		
		residenceService.saveResidence(details);
		
		
		System.out.println("exit");
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
		requestDispatcher.forward(req, resp);
		
	}
	
}
