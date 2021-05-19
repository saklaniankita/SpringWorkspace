package com.autowire.bean;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "StudentList")
public class Student {
	@Id
	@Field("RollId") //This will be ignored and will be saved as _id in db
	private int rollNo;

	@Field("StudName")
	private String name;

	@Field("StudSection")
	private String section;

	@Field("StudAge")
	private int age;

	/**
	 * 
	 * @Value("#root.age ?: 5") :transform a key's value retrieved from the database
	 * before it is used to construct a domain object. Here if age is not set then
	 * it will be persisted as null in database but when retrieved from database its
	 * value will be set to 5 by default
	 * 
	 * @param rollNo
	 * @param name
	 * @param section
	 * @param age
	 */
	@PersistenceConstructor
	public Student(int rollNo, String name, String section, int age) {
		super();
		//System.out.println("Persistence Constructor called !!!");
		this.rollNo = rollNo;
		this.name = name;
		this.section = section;
		this.age = age;
	}
	
	public Student() {
		//System.out.println("Default Constructor called !!!");
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return this.rollNo+" "+this.name+" "+this.age+" "+this.section;
	}

}
