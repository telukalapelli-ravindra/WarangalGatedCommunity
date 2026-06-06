package com.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/validateLogin")
public class ValidateLoginDetailsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String submit = req.getParameter("submit");
		
		if(submit.equals("ResidentLogin")) {
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("residenceLogin");
			
			requestDispatcher.forward(req, resp);
			
		}
		
		else if(submit.equals("PresidentLogin")) {
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("presidentLogin");
			
			requestDispatcher.forward(req, resp);
			
		}
		
	}
}
