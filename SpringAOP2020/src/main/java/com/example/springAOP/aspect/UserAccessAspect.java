package com.example.springAOP.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * execution(* PACKAGE.*.*(..)) any return type with package name PACKAGE , any
	 * class within that package and any method within that class with any no. and
	 * type of arguments
	 * 
	 * POINT CUT : The expression that defines what kind of method I would want to
	 * intercept.
	 * 
	 * ADVICE : Statements that we want to be executed when some method call is
	 * intercepted
	 * 
	 * ASPECT : Combination of POINT CUT & ADVICE is called an ASPECT
	 * 
	 * JOINT POINT : Specific Method Interception. If there are 100 methods that
	 * satisfies the point cut , then there are 100 Joint points
	 * 
	 * Process of surrounding the method calls with Advice is called WEAVING and the
	 * framework is called WEAVER
	 * 
	 * 
	 */
	
	

	/**
	 * @Before annotation will be run before executing method. Such annotation can be used in scenarios 
	 * like checking User Access before any method call
	 * 
	 * @param joinPoint
	 */
	
	//@Before("execution(* com.example.springAOP.business.*.*(..))")
	@Before("com.example.springAOP.CommonJoinPointConfig.businessLayerExceution()") //Using common file CommonJoinPointConfig
	public void before(JoinPoint joinPoint) {

		// Advice
		LOGGER.info("Checking User Access.....");
		LOGGER.info("Intercepted Method call -> {}", joinPoint);
	}

	// @AfterReturning executes the advice only after method executes successfully
	// WITHOUT throwing an exception
	@AfterReturning(value = "execution(* com.example.springAOP.business.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info("{} method returned -> {}", joinPoint, result);

	}

	// @After executes the advice after method executes successfully OR WITH
	// Exception
	@After("com.example.springAOP.CommonJoinPointConfig.dataLayerExceution()")
	public void after(JoinPoint joinPoint) {
		LOGGER.info("After Executing method {}", joinPoint);

	}

	// Executes if some exception is thrown
	@AfterThrowing(value = "execution(* com.example.springAOP.business.*.*(..))", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Object exception) {
		LOGGER.info("{} thrown Exception -> {}", joinPoint, exception);

	}

//	@Around("execution(* com.example.springAOP.business.Business1.*(..))")
//	@Around("com.example.springAOP.CommonJoinPointConfig.businessLayerExceution()")
	@Around("com.example.springAOP.CommonJoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		LOGGER.info("Time taken in executing method {} is {}", joinPoint, endTime - startTime);
	}
	
	
	@Before("com.example.springAOP.CommonJoinPointConfig.beanContainingDao()")
	public void beforeDao(JoinPoint joinPoint) {
		LOGGER.info("Intercepted Method call -> {}", joinPoint);
	}
}
