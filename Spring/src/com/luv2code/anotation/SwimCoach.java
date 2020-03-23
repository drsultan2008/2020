package com.luv2code.anotation;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	FortuneService fortuneService ;
	
	@Value("${foo.email}")
	String email;
	
	@Value("${foo.name}")
	String name;
	
	SwimCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}
	
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
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
