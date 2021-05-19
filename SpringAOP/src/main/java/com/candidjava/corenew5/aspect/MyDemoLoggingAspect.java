package com.candidjava.corenew5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

//  execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)    throws-pattern?)

//  execution(* com.candidjava..*. set*(..))

	/*
	 * @Before("execution(* create())") public void beforeAddAccountAdvice() throws
	 * Throwable {
	 */

	@Before("execution(public * delete*())")
	//@Before("execution(public * com.candidjava.corenew5.LogServiceCommonLog.deleteTest(..))")
	public void beforeAddAccountAdvice() throws Throwable {
		System.out.println("\n============>>> Delete method @Before......");
	}

	@Around("execution(public * create*())") // PointCut
	public Object beforeAddAccountAdvice(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println("\n=====>>> Executing @before advice on addAccount()");

		// invokes method
		pjp.proceed();

		System.out.println("\n=====>>> Executing @afer advice on addAccount()");

		return null;
	}
}

/*
 * //Advice : before after around throw return
 */