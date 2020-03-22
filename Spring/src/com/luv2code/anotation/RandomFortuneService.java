package com.luv2code.anotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	private String[] msg = {"Hello 1","Hello 2", "Hello 3"};
	
	Random myRandom = new Random();
	@Override
	public String dailyFortuneService() {
		// TODO Auto-generated method stub
		int index = myRandom.nextInt(msg.length);
		return msg[index];
	}

}
