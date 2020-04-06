package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// Read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// Get the bean from string container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		// Call 
		List<Account> accounts= accountDAO.findAccounts();
		
		System.out.println("Main progam: AfterReturningApp");
		System.out.println(accounts); 
		
		// Close context
		context.close();
		
	}

}
