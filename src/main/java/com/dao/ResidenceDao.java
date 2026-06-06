package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;

import com.model.ResidenceLoginDetails;
import com.model.ResidencePersonalDetails;
import com.util.HibernateConnection;

public class ResidenceDao {
	
	private static ResidenceDao residenceDao;
	
	private ResidenceDao() {
		
	}
	
	
	//RegisterLoginDao class instance by following SingleTon
	public static ResidenceDao getResidenceDao() {
		
		if(residenceDao==null) {
			
			residenceDao=new ResidenceDao();
			
			return residenceDao;
		}
		
		return residenceDao;
		
	}
	
	
	//Session Object creation
	private Session getSession() {
		
		System.out.println(HibernateConnection.getSessionFactory());
		
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
	
	public List<ResidenceLoginDetails> validateResidenceLogin(String emailId, String password) {
		
		SessionFactory sessionFactory = HibernateConnection.getSessionFactory();
		System.out.println(sessionFactory);
		
		Session session = getSession();
		
		session.beginTransaction();
		
		SelectionQuery<ResidenceLoginDetails> selectionQuery = session.createSelectionQuery("Select s From ResidenceLoginDetails s where s.emailId=?1 and s.password=?2", ResidenceLoginDetails.class);
		
		selectionQuery.setParameter(1, emailId);
		selectionQuery.setParameter(2, password);
		
		List<ResidenceLoginDetails> list = selectionQuery.getResultList();
		
		return list;
		
	}
	
	
	public ResidencePersonalDetails getResidenceDetailsByLoginid(int loginId ) {
		
		Session session = getSession();
		
		session.beginTransaction();
		
		ResidencePersonalDetails residencePersonalDetails = session.find(ResidencePersonalDetails.class, loginId);
		
		session.getTransaction().commit();
		
		return residencePersonalDetails;
		
	}
	
	public int getResidenceLoginIdByEmailId(String emailId) {
		
		Session session = getSession();
		
		session.beginTransaction();
		
		SelectionQuery<Integer> selectionQuery = session.createSelectionQuery("select s.residenceLoginId from ResidenceLoginDetails s where s.emailId=?1", Integer.class);
		
		Integer loginId = selectionQuery.setParameter(1, emailId).getSingleResultOrNull();
		
		return loginId;
	}
	
	
	
	public ResidencePersonalDetails getResudencePersonalDetailsById(int residenceId) {
		
		Session session = getSession();
		
	    	ResidencePersonalDetails residencePersonalDetails = session.find(ResidencePersonalDetails.class, residenceId);
	    
	    session.close();
	    
	    return residencePersonalDetails;
		
	}
}
