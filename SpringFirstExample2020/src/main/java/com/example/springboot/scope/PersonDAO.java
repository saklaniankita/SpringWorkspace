package com.example.springboot.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.springboot.basic.BinarySearchAlgo;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonDAO {
	private Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);
	@Autowired
	JdbcConnection jdbcConnection;

	public JdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(JdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
	/**
	 * The PostConstruct annotation is used on a method that needs to be executed 
	 * after dependency injection is done to perform any initialization
	 * 
	 * It will be called just once per application context for a singleton bean 
	 * 
	 * It will be called as many times as the prototype bean is created
	 * 
	 */
	@PostConstruct
	public void postConstruct() {
		LOGGER.info("postConstruct called");
	}
	
	/**
	 * The PreDestroy annotation is used on methods as a callback notification to signal 
	 * that the instance is in the process of being removed by the container
	 * 
	 * It will be called just once per application context for a singleton bean 
	 * 
	 * This method is never called if the bean scope is PROTOTYPE
	 */
	@PreDestroy
	public void preDestroy() {
		LOGGER.info("preDestroy called");
	}

}
