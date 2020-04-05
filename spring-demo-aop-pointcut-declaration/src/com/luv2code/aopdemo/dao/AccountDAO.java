package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass()+" Doing my Database work");
	}
	
	public boolean addOther() {
		System.out.println(getClass()+ " Doing my Database work");
		return true;
	}
}
