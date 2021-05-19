package com.candidjava.springJDBC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddressDAO {
	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;

	public void insertAddress(String city, String state, long pincode) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","august@27");
			if (connect != null) {
				System.out.println("Connected to database !!!");
				preparedStatement = connect.prepareStatement("insert into address values(?,?,?)");
				preparedStatement.setString(1, city);
				preparedStatement.setString(2, state);
				preparedStatement.setLong(3, pincode);
				preparedStatement.executeUpdate();
				System.out.println("Adress with pin: "+pincode+" inserted into database");
				connect.close();
				System.out.println("Connection close !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
