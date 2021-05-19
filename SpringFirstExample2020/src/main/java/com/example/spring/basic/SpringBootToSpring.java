package com.example.spring.basic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



//@SpringBootApplication
@Configuration
@ComponentScan
public class SpringBootToSpring {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringBootToSpring.class);

	public static void main(String[] args) {
		//ApplicationContext applicationContext = SpringApplication.run(SpringBootToSpring.class, args);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBootToSpring.class);
		CDIService cdiService = applicationContext.getBean(CDIService.class);
		System.out.println(cdiService);
		
		
		
	}

}
