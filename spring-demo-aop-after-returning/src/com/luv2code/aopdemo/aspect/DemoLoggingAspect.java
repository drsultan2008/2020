package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println(getClass()+ " beforeAddcountAdvice");
		
		//Display method
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		//Display argument
		Object[] args = joinPoint.getArgs();
		
		for (Object iterArg : args) {
			if (iterArg instanceof Account) {
				Account theAccount = (Account) iterArg;
				
				System.out.println("The name: " + theAccount.getName());
				System.out.println("The level: "+ theAccount.getLevel());
			}
		}
	}
	
}
