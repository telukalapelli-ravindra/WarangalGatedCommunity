package com.dto;

public class PresidentDetails {

	private int  presidentId;
	
	private String name;
	
	private int age;
	
	private String emailId;
	
	private String password;
	
	public PresidentDetails() {
		
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PresidentDetails [presidentId=" + presidentId + ", name=" + name + ", age=" + age + ", emailId="
				+ emailId + ", password=" + password + "]";
	}
	
	
}
