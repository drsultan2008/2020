package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/luv2code/springdemo/applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDaily());
		
		context.close();
	}
}
