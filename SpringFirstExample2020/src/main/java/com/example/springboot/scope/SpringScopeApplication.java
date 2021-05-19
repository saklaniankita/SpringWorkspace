package com.example.springboot.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.springboot.basic.BinarySearchAlgo;
import com.example.springboot.basic.SpringSampleApplication;

@SpringBootApplication
public class SpringScopeApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringScopeApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringScopeApplication.class, args);
		PersonDAO personDAO1 = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);
		
		LOGGER.info("{}", personDAO1);
		LOGGER.info("{}", personDAO1.getJdbcConnection());
		
		LOGGER.info("{}",personDAO2);
		LOGGER.info("{}",personDAO2.getJdbcConnection());
		
	
		
		//For Different application context even the singleton bean will return
		//different objects
		
		ApplicationContext applicationContextNew = SpringApplication.run(SpringScopeApplication.class, args);
		PersonDAO personDAO3 = applicationContextNew.getBean(PersonDAO.class);
		 
		if(personDAO1 == personDAO3)
			LOGGER.info("person DAO1 is same as personDAO3");
		else 
			LOGGER.info("person DAO1 is NOT same as personDAO3");
}}
