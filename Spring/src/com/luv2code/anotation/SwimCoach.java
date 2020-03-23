package com.luv2code.anotation;

public class SwimCoach implements Coach {

	FortuneService fortuneService ;
	
	SwimCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Hello method DailyWorkout on SwimCoach";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.dailyFortuneService();
	}

}
