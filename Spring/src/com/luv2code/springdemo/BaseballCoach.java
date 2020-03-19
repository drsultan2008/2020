package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	BaseballCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDaily() {
		return "Baseball spend 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}
}
