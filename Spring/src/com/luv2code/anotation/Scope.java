package com.luv2code.anotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		Coach betaCoach = context.getBean("tennisCoach",Coach.class);
		
		boolean flag = alphaCoach == betaCoach;
		System.out.println(flag);
	}

}
