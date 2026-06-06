package com.util;

import com.model.PresidentPersonalDetails;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class HibernateListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
//		System.out.println("hello");
//		
//		HibernateConnection.getConfiguration();
//		HibernateConnection.getSessionFactory();
		
		
	}

}
