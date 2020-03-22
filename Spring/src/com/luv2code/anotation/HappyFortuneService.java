package com.luv2code.anotation;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String dailyFortuneService() {
		// TODO Auto-generated method stub
		return "HelloHapplyDailyFortuneService";
	}

}
