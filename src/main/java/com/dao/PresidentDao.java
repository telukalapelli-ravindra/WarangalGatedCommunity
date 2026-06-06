package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;

import com.model.PresidentLoginDetails;
import com.model.PresidentPersonalDetails;
import com.util.HibernateConnection;

public class PresidentDao {


	private static PresidentDao presidentDao;
	
	private PresidentDao() {
		
	}
	
	
	//RegisterLoginDao class instance by following SingleTon
	public static PresidentDao getPresidentDao() {
		
		if(presidentDao==null) {
			
			presidentDao=new PresidentDao();
			
			return presidentDao;
		}
		
		return presidentDao;
		
	}
	
	
	//Calling a method for opening Session
	private Session getSession() {
		
		return HibernateConnection.getSessionFactory().openSession();
		
	}

	//Method for saving Residence Details
	public void save(Object object) {
		
		SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.persist(object);
		
		
		session.getTransaction().commit();
		
		
	}
	
	public List<PresidentLoginDetails> findLoginDetailsByEmail(String email) {
		
		Session session = getSession();
		
		SelectionQuery<PresidentLoginDetails> selectionQuery = session.createSelectionQuery("From PresidentLoginDetails where emailId=?1 ", PresidentLoginDetails.class);
		
		SelectionQuery<PresidentLoginDetails> setParameter = selectionQuery.setParameter(1, email);
		
		return selectionQuery.getResultList();
		
		
	}
	
	public PresidentPersonalDetails findByLoginDetails(PresidentLoginDetails loginDetails) {
		
		Session session = getSession();
		
		SelectionQuery<PresidentPersonalDetails> selectionQuery = session.createSelectionQuery("From PresidentPersonalDetails where presidentLoginDetails=?1", PresidentPersonalDetails.class);
		
		return selectionQuery.setParameter(1, loginDetails).getSingleResult();
	}
	
}
