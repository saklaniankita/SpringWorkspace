package com.example.springAOP.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springAOP.data.Dao2;



@Service
public class Business2 {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Dao2 dao2;
	
	public String calculateSomething() {
		LOGGER.info("I am in calculateSomething() method of Business2 class");
		return dao2.retrieveData();
	}
}
