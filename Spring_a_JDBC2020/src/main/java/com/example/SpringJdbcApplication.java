package com.example;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springJdbc.bean.Person;
import com.example.springJdbc.dao.PersonJdbcDao;


/**
 * 
 * @author ankitasaklani
 *
 */
//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner{
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All Users => {}",personJdbcDao.findAll());
//		LOGGER.info("Users with id 10001 -> {}",personJdbcDao.findById(10001));
//		LOGGER.info("Users with name Ranga -> {}",personJdbcDao.findByName("Ranga"));
//		LOGGER.info("Deleting User with id 10004 -> {}",personJdbcDao.deleteById(10004));
//		LOGGER.info("Deleting User with id 10002 & name James -> {}",personJdbcDao.deleteByIdandName(10002,"James"));
//		LOGGER.info("Inserting one person -> {}",personJdbcDao.insert(new Person(10005, "Adam", "Vegas", new Date())));
//		LOGGER.info("Updating Person with id 10002 -> {}", personJdbcDao.update(new Person(10002, "Adam", "Vegas", new Date())));
		
	}

}
