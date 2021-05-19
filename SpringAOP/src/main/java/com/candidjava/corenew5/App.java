package com.candidjava.corenew5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
@EnableAspectJAutoProxy  //To enable AspectJ
@ComponentScan("com.candidjava.corenew5")
public class App {
	public static void main(String[] args) {

		// ClassPathXmlApplicationContext context=new
		// ClassPathXmlApplicationContext("applicationContext.xml");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		LogService lg1 = context.getBean("logservice", LogService.class);
		LogService lg2 = context.getBean("logservice1", LogService.class);

		System.out.println(lg1 == lg2);

		lg2.logError("  null pointer exceeption");
		lg1.deleteTest();
		lg2.createTest();

		context.getBean("userServiceIml", UserServiceIml.class).create();

		context.close();

	}
}