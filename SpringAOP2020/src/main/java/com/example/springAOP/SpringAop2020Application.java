package com.example.springAOP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springAOP.business.Business1;
import com.example.springAOP.business.Business2;
import com.example.springAOP.data.Dao1;

@SpringBootApplication
public class SpringAop2020Application implements CommandLineRunner{
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Business1 business1;
	
	@Autowired
	private Dao1 dao1;

	public static void main(String[] args) {
		SpringApplication.run(SpringAop2020Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		business1.calculateSomething();
		//dao1.retrieveData();
	}

}
