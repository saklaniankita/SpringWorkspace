package com.candidjava.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component; 

/**
 * Try commenting both ctx.getBean line and notice that Spring still loads
 * Singleton(and NOT protoytpe) beans into it’s context before we have even
 * requested it i.e when below statement is executed
 *     AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfiguration.class)
 * all singleton beans within the package mentioned in @ComponentScan annotation gets instantiated once and for all
 * whereas Prototype beans are instantiated every time only when we specifically write
 * 				MyConsumer mbc1 = (MyConsumer) ctx.getBean("myConsumer");
 *
 * Also ctx.refresh() must be called after registering the Configuration class
 * that contains beans method
 * 
 * @author Ankita
 * 
 */

public class MySpringApp {
	// it won't autowire because the class is not marked with @component so it is
	// giving null value

	@Autowired
	private String testString;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MyConfiguration.class);
		ctx.refresh(); // ?????

		// "myService" is the name of the class MyService( starting with lower case
		// alphabet). Otherwise we mention an alias : @Component("myServiceClass")
		//This is singleton bean has already been created above
		MyService mb1 = (MyService) ctx.getBean("myService");
		MyService mb2 = (MyService) ctx.getBean("myService");

		if (mb1.hashCode() == mb2.hashCode())
			System.out.println("The two MyService obejcts are SAME " + mb1.hashCode() + " " + mb2.hashCode());
		else
			System.out.println("The two MyService Objects are DIFFERENT " + mb1.hashCode() + " " + mb2.hashCode());

		//This is a prototype bean so will be instantiated everytime we call ctx.getBean method
		MyConsumer mbc1 = (MyConsumer) ctx.getBean("myConsumer");
		MyConsumer mbc2 = (MyConsumer) ctx.getBean("myConsumer");
		//
		if (mbc1.hashCode() == mbc2.hashCode())
			System.out.println("The two MyConsumer obejcts are SAME "+ mbc1.hashCode() + " " + mbc2.hashCode());
		else
			System.out.println("The two MyConsumer Objects are DIFFERENT "+ mbc1.hashCode() + " " + mbc2.hashCode());

		//This won't work because though testString has been autowired but @Bean tag is still not present
		MySpringApp app = new MySpringApp();
		System.out.println("TestString in SpringApp.java : " + app.testString);
		
		//This will work bcoz testString has been autowired and @Bean has been used MyConfiguration.java class
		 mbc1.myFunction();

		 //This will also work for the same reason
	    String str = (String)ctx.getBean("testString");
		System.out.println("Bean string : "+str);
		
		

		ctx.close();
	}

}