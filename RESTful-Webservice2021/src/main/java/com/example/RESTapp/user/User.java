package com.example.RESTapp.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Past(message = "Birth date should be a past date")
	private Date birthDate;
	
	@JsonIgnore  //For static filtering
	private String password;
	
	public User() {
		
	}

	public User(Integer id, String name, Date birthDate, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.password = pwd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
