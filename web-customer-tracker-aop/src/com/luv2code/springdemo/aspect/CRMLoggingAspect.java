package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	// Setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	// Setup poincut declaratinos
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint jointPoint) {
		String method = jointPoint.getSignature().toShortString();
		myLogger.info("===> @Before: calling method: "+ method);
		
		Object[] arg = jointPoint.getArgs();
		for (Object i:arg) {
			myLogger.info("===> @Before: argument: "+i);
		}
	}
	
	// add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()", returning="result")
	public void after(JoinPoint joinPoing, Object result) {
		String method = joinPoing.getSignature().toShortString();
		myLogger.info("===> @AfterReturning method: "+method);
		
		myLogger.info("===> Result: "+result);
	}
}
