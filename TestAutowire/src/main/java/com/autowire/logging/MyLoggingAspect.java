package com.autowire.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	/**
	 * Being called 3 times for every layer(controller, service, Repository) if
	 * ("execution(public * find*(..))") is used
	 * 
	 * If ("execution(public * com.autowire.controller.AutowireController.findAllStudents(..))")
	 * pattern is used it is called just once for the method specified
	 * 
	 * @throws Throwable
	 */
	// @Before("execution(public * find*(..))")
	//@Before("execution(public * com.autowire.controller.AutowireController.findAllStudents(..))")
	public void addBeforeLogging(JoinPoint jp) throws Throwable {
		System.out.println("Finding Data.....");
		System.out.println("*******" + jp.getThis().toString());
		// System.out.println(this.getClass());
	}

	/**
	 * Being called 3 times???
	 * 
	 * @throws Throwable
	 */
	// @After("execution(public * find*())")
	public void addAfterLogging() throws Throwable {
		System.out.println("Done Finding Data.....");
	}

	@Around("execution(public * com.autowire.controller.AutowireController.findAllStudents(..))")
	/**
	 * Being called 3 times???
	 * 
	 * @throws Throwable
	 */
	// @Around("execution(public * find*())")
	public Object addAroundLogging(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Logging around the method....1");
		Object obj = pjp.proceed();
		System.out.println("Logging around the method....2");
		return obj;
	}

	/**
	 * Being called 3 times
	 * 
	 * @throws Throwable
	 */
	@Before("execution(public * updateStudentSection*(..))")
	public void addBeforeupdateStudentSection() throws Throwable {
		System.out.println("Updating Student Section.....");
	}
}
