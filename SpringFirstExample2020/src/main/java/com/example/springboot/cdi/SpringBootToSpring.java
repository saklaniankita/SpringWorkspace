package com.example.springboot.cdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootToSpring {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringBootToSpring.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootToSpring.class, args);
		CDIService cdiService = applicationContext.getBean(CDIService.class);
		
		LOGGER.info("service -{}, DAO - {}",cdiService,cdiService.getCdiDao());
		
	}

}
