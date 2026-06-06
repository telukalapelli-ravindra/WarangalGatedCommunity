package com.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PresidentPersonalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  presidentId;
	
	private String name;
	
	private int age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "logindetails")
	private PresidentLoginDetails presidentLoginDetails;
	
	
	
	public PresidentPersonalDetails() {
		
	}

	public PresidentPersonalDetails(int presidentId, String name, int age,
			PresidentLoginDetails presidentLoginDetails) {
		super();
		this.presidentId = presidentId;
		this.name = name;
		this.age = age;
		this.presidentLoginDetails = presidentLoginDetails;
	}

	public PresidentPersonalDetails(String name, int age, PresidentLoginDetails presidentLoginDetails) {
		super();
		this.name = name;
		this.age = age;
		this.presidentLoginDetails = presidentLoginDetails;
	}
	
	
	public PresidentPersonalDetails(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getPresidentId() {
		return presidentId;
	}

	public void setPresidentId(int presidentId) {
		this.presidentId = presidentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PresidentLoginDetails getPresidentLoginDetails() {
		return presidentLoginDetails;
	}

	public void setPresidentLoginDetails(PresidentLoginDetails presidentLoginDetails) {
		this.presidentLoginDetails = presidentLoginDetails;
	}
	
	

	
	@Override
	public String toString() {
		return "PresidentPersonalDetails [presidentId=" + presidentId + ", name=" + name + ", age=" + age
				+ ", presidentLoginDetails=" + presidentLoginDetails + "]";
	}

	
	
	
	
}
