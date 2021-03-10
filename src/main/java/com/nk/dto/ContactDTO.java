package com.nk.dto;

import java.sql.Date;

public class ContactDTO {
	private int id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private int gender;
	private String phoneNumber;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ContactDTO(int id, String firstName, String lastName, Date birthdate, int gender, String phoneNumber,
			String description) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}
	
	public ContactDTO(String firstName, String lastName, Date birthdate, int gender, String phoneNumber,
			String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}
	public ContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
