package com.candidjava.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class MyConsumer {
	@Autowired
	private String testString;
	
	
	public MyConsumer() {
		System.out.println("MyConsumer instance created "+this.hashCode());
	}

	public void myFunction() {
		System.out.println("testString In Myconsumenr : "+testString);
	}
	
}