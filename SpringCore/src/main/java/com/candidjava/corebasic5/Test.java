package com.candidjava.corebasic5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Test {
	@Bean(name="tmp", initMethod = "initializeObject", destroyMethod = "destroyObject")
	public UserService myMethod() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Test.class);
        
	     
        /*
         * String s1=(String)context.getBean("myString"); System.out.println(s1);
         */
         
        UserService us1=(UserService) context.getBean("userServiceImpl");
        System.out.println("Returning from Test class myMethod()");
        return us1;
	}
	
	public void initializeObject() {
		System.out.println("Initializing before calling myMethod().....");
	}
	
	public void destroyObject() {
		System.out.println("Destroying objects at the end");
	}
}
