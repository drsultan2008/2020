package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class LuvAopExpressions {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setterDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getterDaoPackage() {}
	
	// For Dao Package no getter setter
	@Pointcut("forDaoPackage() && !(setterDaoPackage() || getterDaoPackage())")
	public void forDaoPackageNoGetterSetter() {}
}
