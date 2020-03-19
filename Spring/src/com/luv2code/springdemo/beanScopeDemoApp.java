package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanScopeDemoApp {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean flag = theCoach == alphaCoach;
		
		System.out.println("is Singleton: " + flag);
		System.out.println("Memory theCoach: "+ theCoach);
		System.out.println("Mymory alphacoach: "+ alphaCoach);
		
		context.close();
	}
}
