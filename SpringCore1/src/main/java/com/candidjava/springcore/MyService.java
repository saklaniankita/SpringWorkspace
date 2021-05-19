package com.candidjava.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Scope("singleton") = @Scope. If we do not write anything, by default it takes
 * singleton scope
 * 
 * @author Ankita
 *
 */
@Component
@Scope("singleton")
public class MyService {
	@Autowired
	MyConsumer myConsumer;

	public MyService() {
		System.out.println("MyService instance created "+this.hashCode());
	}
	
}