package com.example.springAOP.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class Dao2 {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	public String retrieveData() {
		LOGGER.info("I am in retrieveData() method of Dao2 class");
		return "Dao2";
	}
	
	
}
