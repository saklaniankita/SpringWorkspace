package com.example.springAOP.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springAOP.data.Dao1;

@Service
public class Business1 {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Dao1 dao1;
	
	public String calculateSomething() {
		LOGGER.info("I am in calculateSomething() method of Business1 class");
		return dao1.retrieveData();
	}
}
