package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
@Aspect
@Order(1)
public class DemoLoggingAspect {
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("@Around getFortune: "+ method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			proceedingJoinPoint.proceed();
		}
		catch(Exception e) {
			myLogger.warning(e.getMessage());
//			result = "ERROR, but don't worry, your private AOP is on the way!";
			// rethrow exception
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		myLogger.info("Duration convert by @Around AOP:: "+ duration/1000);
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("@After (Finally): "+ method);
	}
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("Excecuting by @AfterThrowing: " +method);
		
		myLogger.info("The exception by @AfterThowing bypass: "+exc);
	}
	
	// Add new advice for AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning="res")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> res) {
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("Method: "+method);
		myLogger.info("Get list: "+ res);
		
		// Post-Process modify data
		convertAccountNameToUpperCase(res);
		myLogger.info("Converted by @AfterReturning");
	}
	
	private void convertAccountNameToUpperCase(List<Account> res) {
		for (Account iterAcc: res) {
			iterAcc.setName(iterAcc.getName().toUpperCase());
		}
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		myLogger.info(getClass()+ " beforeAddcountAdvice");
		
		//Display method
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		myLogger.info("Method: " + methodSignature);
		//Display argument
		Object[] args = joinPoint.getArgs();
		
		for (Object iterArg : args) {
			if (iterArg instanceof Account) {
				Account theAccount = (Account) iterArg;
				
				myLogger.info("The name: " + theAccount.getName());
				myLogger.info("The level: "+ theAccount.getLevel());
			}
		}
	}
	
}
