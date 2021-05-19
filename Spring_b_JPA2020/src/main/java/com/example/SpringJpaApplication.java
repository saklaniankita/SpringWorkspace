package com.example;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonJpaRepository;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner{
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//LOGGER.info("Person with id 2222 => {}",personJpaRepository.findById(2222));
		
		Person person = personJpaRepository.insert(new Person("Ahmed", "California", new Date()));
		LOGGER.info("Person inserted :" +person);
		
		//Inserting/Updating records
//		LOGGER.info("Person with id 1111 updated => {}", 
//				personJpaRepository.insert(new Person(1111, "Rachel", "Florida", new Date())));
//		
//		LOGGER.info("Person with id 1111 updated => {}", 
//				personJpaRepository.insert(new Person("Rachel", "Florida", new Date())));
//		
//		//No need to pass id because hibernate will generate the id automatically and will not consider id provided by us
//		LOGGER.info("Person with id 5555 inserted => {}", 
//				personJpaRepository.insert(new Person(5555, "Christin", "Utah", new Date())));
//		
//		LOGGER.info("Person with id 5555 inserted => {}", 
//				personJpaRepository.insert(new Person("Christin", "Utah", new Date())));
//		
//		personJpaRepository.deleteById(2222);
//		
//		LOGGER.info("Running Named query written in JPQL to fetch all persons => {}",personJpaRepository.findAll());
	}

}
