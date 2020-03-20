package com.luv2code.anotation;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach{
	@Override
	public String getDailyWorkout() {
		return "TenisCoach say workout 30 minutes ";
	}
}
