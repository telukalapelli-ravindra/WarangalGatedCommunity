package com.dto;

public class PresidentPersonalDetailsResponseDTO {

	private int  presidentId;
	
	private String name;
	
	private int age;
	
	public PresidentPersonalDetailsResponseDTO() {
		
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

	@Override
	public String toString() {
		return "PresidentPersonalDetailsResponseDTO [presidentId=" + presidentId + ", name=" + name + ", age=" + age
				+ "]";
	}
	
	
	
}
