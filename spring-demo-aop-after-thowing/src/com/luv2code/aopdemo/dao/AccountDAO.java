package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire){
		if (tripWire) {
			// Throw errors :))
			throw new RuntimeException("No soup for you");
		}
		List<Account> list = new ArrayList<>();
		list.add(new Account("John", "leve1"));
		list.add(new Account("Duy", "level100"));
		list.add(new Account("Duyy", "level100"));
		return list;
	}
	
	public void addAccount(Account account, boolean flag) {
		System.out.println(getClass()+" Doing my Database work");
	}
	
	public boolean addOther() {
		System.out.println(getClass()+ " Doing my Database work");
		return true;
	}

	public String getName() {
		System.out.println(getClass()+ "getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ " setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ " getServicecode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" setServiceCode");
		this.serviceCode = serviceCode;
	}
	
}
