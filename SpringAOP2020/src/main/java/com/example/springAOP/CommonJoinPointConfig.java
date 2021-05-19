package com.example.springAOP;

import org.aspectj.lang.annotation.Pointcut;

/**
 * This is a common file for having Pointcut definitions
 * @author ankitasaklani
 *
 */
public class CommonJoinPointConfig {

	@Pointcut("execution(* com.example.springAOP.data.*.*(..))")
	public void dataLayerExceution() {
	}
	
	@Pointcut("execution(* com.example.springAOP.business.*.*(..))")
	public void businessLayerExceution() {}
	
	@Pointcut("com.example.springAOP.CommonJoinPointConfig.dataLayerExceution() && "
			+ "com.example.springAOP.CommonJoinPointConfig.businessLayerExceution()")
	public void allLayerExceution() {}
	
	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {}
	
	@Pointcut("@annotation(com.example.springAOP.aspect.TrackTime)")
	public void trackTimeAnnotation() {}
	
}
