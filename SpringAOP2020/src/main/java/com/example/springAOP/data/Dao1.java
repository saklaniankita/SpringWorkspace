package com.example.springAOP.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.springAOP.aspect.TrackTime;

@Repository
public class Dao1 {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@TrackTime
	public String retrieveData() {
		LOGGER.info("I am in retrieveData() method of Dao1 class");
		return "Dao1";
	}
}
