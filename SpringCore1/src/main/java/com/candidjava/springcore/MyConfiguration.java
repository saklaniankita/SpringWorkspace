package com.candidjava.springcore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



//No need for @Bean tag. 
// We would need @Bean tag if the class is outside the mentioned package 

@ComponentScan("com.candidjava")
@Configuration
public class MyConfiguration {

//	@Bean
//    public MyService createMyService() {
//		return new MyService();
//	}
//	
//	@Bean
//    public MyConsumer createMyConsumer() {
//		return new MyConsumer();
//	}

	@Bean
	public String testString() {
		return "This is a test string";
	}
	
	@PostConstruct
	public void initIt() throws Exception {
		System.out.println("Init method after properties are set : ");
	}

	@PreDestroy
	public void cleanUp() throws Exception {
		System.out.println("Spring Container is destroy! Customer clean up");
	}
}