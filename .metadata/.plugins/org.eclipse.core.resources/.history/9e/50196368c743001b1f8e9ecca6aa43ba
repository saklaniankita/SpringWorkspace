package com.example.springboot.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:app.properties")
public class SpringSampleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringSampleApplication.class, args);
		BinarySearchAlgo binarySearch = applicationContext.getBean(BinarySearchAlgo.class);
		
		//To understand the use @Scope
		BinarySearchAlgo binarySearch1 = applicationContext.getBean(BinarySearchAlgo.class);
		if(binarySearch == binarySearch1)
			System.out.println("SAME");
		else
			System.out.println("DIFFERENT");
		
		
		int num = binarySearch.binarySearch(new int[] {1, 2,3},2);
		System.out.println(num);
		
		//to use properties file
		System.out.println(binarySearch.getUrl());
	}

}
