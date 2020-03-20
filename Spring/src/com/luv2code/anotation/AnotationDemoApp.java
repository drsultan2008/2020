package com.luv2code.anotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		context.close();
	}

}
