package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	@Override
	public String getDaily() {
		// TODO Auto-generated method stub
		return "TrackCoach spend 30 minutes";
	}

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
