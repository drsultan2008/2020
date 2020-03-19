package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String team;
	private String emailAddress;

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("inside setter method: team");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("inside setter method: emailAddress");
		this.emailAddress = emailAddress;
	}

	CricketCoach(){
		System.out.println("CriketCoach no arg contructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("inside setter method: fortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDaily() {
		return "CricketCoach spend 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyFortune();
	}

}
