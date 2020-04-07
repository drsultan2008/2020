package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// Read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// Get the bean from string container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		// Call 
		List<Account> accounts=null;
		boolean tripWire = false;
		try {
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("Cause exception: "+ exc);
		}
		System.out.println("Main progam: AfterThowingDemoApp");
		System.out.println(accounts); 
		
		// Close context
		context.close();
		
	}

}
