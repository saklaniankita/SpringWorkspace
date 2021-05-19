package com.example.springboot.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.springboot.componentscan.ComponentDAO;


/**
 * If the component classes are NOT in the same package as SpringBootApplication
 * then we have to specify their package using @ComponentScan
 * @author Ankita
 *
 */
@SpringBootApplication
@ComponentScan("com.example.spring.componentscan")
public class SpringComponentScanApplication {
private static Logger LOGGER = LoggerFactory.getLogger(SpringComponentScanApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringComponentScanApplication.class, args);
		ComponentDAO componentDao = applicationContext.getBean(ComponentDAO.class);
		
		LOGGER.info("{}", componentDao);
	}
}
