package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoLoggingAspect {
	// this is where we add all of out related advices  for logging
	// let's start with an @Before advicd
	//  Because method alway public, so not typing public...
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("Executing @Before advice on addAddcount()");
	}
}
