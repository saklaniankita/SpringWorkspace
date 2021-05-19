package com.example.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * context.getBeanDefinitionNames() will return the names of all beans that are being configured via AutoConfiguration 
 * feature of @SpringBootApplication
 * 
 * you can look into spring-boot-autoconfigure.jar to explore the classes that gets autoconfigured
 * 
 * 
 * @author ankitasaklani
 *
 */
@SpringBootApplication
public class SpringBootProjectApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SpringBootProjectApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProjectApplication.class, args);
		LOGGER.info("No. of context configured: "+String.valueOf(context.getBeanDefinitionCount()));
		for(String name : context.getBeanDefinitionNames()) {
			LOGGER.info(name);
		}
	}

}