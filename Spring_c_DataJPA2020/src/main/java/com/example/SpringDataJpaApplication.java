package com.example;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.entity.Person;
import com.example.jpa.repository.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner{
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository personSpringDataRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Person with id 2222 => {}",personSpringDataRepository.findById(2222));
		
		//Inserting/Updating records
		LOGGER.info("Person with id 1111 updated => {}", 
				personSpringDataRepository.save(new Person(1111, "Rachel", "Florida", new Date())));
		
		LOGGER.info("New Person added => {}", 
				personSpringDataRepository.save(new Person("Rachel", "Florida", new Date())));
		
		personSpringDataRepository.deleteById(2222);
		
		LOGGER.info("All Persons => {}",personSpringDataRepository.findAll());
	}

}
