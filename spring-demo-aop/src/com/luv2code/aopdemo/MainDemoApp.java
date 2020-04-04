package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// Read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// Get the bean from string container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		// Call the business method
		accountDAO.addAccount();
		membershipDAO.addSillyMember();
		// Close context
		context.close();
		
	}

}
