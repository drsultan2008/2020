package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addSillyMember() {
		System.out.println(getClass()+" Doing my database work");
	}
}
