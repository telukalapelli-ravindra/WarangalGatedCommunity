package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.model.Complaints;
import com.model.ResidencePersonalDetails;
import com.util.HibernateConnection;

public class ComplaintDAO {

	//ComplaintDAO Object Creation
	private static ComplaintDAO complaintDao;
	
	private ComplaintDAO() {
		
	}
	
	public static ComplaintDAO getComplaintDAO() {
		
		if(complaintDao==null) {
			
			complaintDao=new ComplaintDAO();
			
			return complaintDao;
			
		}
		
		return complaintDao;
		
	}
	
//------------------------------------------------------------------------------------
	
	//Creating session
	private Session getSession() {
		
		return HibernateConnection.getSessionFactory().openSession();
	}
	
	
	// saving complaint into complaint table
	public void saveComplaint(Complaints complaints) {
		
		Session session = getSession();
		
		session.beginTransaction();
		
		session.persist(complaints);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	//Fetching all complaints for a resident
	public List<Complaints> getComplaints(ResidencePersonalDetails residencePersonalDetails) {
		
		Session session = getSession();
		
		SelectionQuery<Complaints> selectionQuery = session.createSelectionQuery("from Complaints where residencePersonalDetails=?1",Complaints.class);
		
		List<Complaints> list = selectionQuery.setParameter(1, residencePersonalDetails).getResultList();
		
		return list;
	}
	
	// Fetching all Complaints for PResident View
	public List<Complaints> getAllComplaintList(){
		
		Session session = getSession();
		
		SelectionQuery<Complaints> selectionQuery = session.createSelectionQuery("From Complaints", Complaints.class);
		
		 List<Complaints> resultList = selectionQuery.getResultList();
		 
		// System.out.println(resultList);
		 
		 return resultList;
	}
	
	public Complaints getComplaintById(int complaintId) {
		
		Session session = getSession();
		
		Complaints complaints = session.find(Complaints.class, complaintId);
		
		return complaints;
		
	}
	
	//Update Status Of Complaint
	public Complaints updateStatus(Complaints complaint) {
		
		Session session = getSession();
		
		session.beginTransaction();
		
		Complaints complaints = session.merge(complaint);
		
		session.getTransaction().commit();
		
		return complaints;
		
	}
	
}
