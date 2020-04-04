package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// Read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// Get the bean from string container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		// Call the business method
		accountDAO.addAccount();
		// Close context
		context.close();
		
	}

}
