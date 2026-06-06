package com.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Complaints;
import com.model.PresidentLoginDetails;
import com.model.PresidentPersonalDetails;
import com.model.ResidenceLoginDetails;
import com.model.ResidencePersonalDetails;

public class HibernateConnection {

	private static SessionFactory sessionFactory;
	

	private static Configuration getConfiguration(){
		Configuration cfg=new Configuration();
		
		cfg.configure();
		
		cfg.addAnnotatedClass(PresidentLoginDetails.class);
		cfg.addAnnotatedClass(PresidentPersonalDetails.class);
		cfg.addAnnotatedClass(ResidencePersonalDetails.class);
		cfg.addAnnotatedClass(ResidenceLoginDetails.class);
		cfg.addAnnotatedClass(Complaints.class);
		
		return cfg;
	
	}
	
	public static SessionFactory getSessionFactory() {
		
		
		
		if(sessionFactory==null) {
			Configuration configuration = getConfiguration();
		sessionFactory= configuration.buildSessionFactory();
		
		return sessionFactory;
		
		}
		
		return sessionFactory;
		
	}
	
	
}
