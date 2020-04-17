package com.luv2code.springboot.demo.springbootmycoolapp.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	// Inject value form properties
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World ! Time on server is " + LocalDate.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Hello daily workout!";
	}
	
	@GetMapping("/fortune")
	public String sayFortune() {
		return "Hello daily fortune";
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return coachName + " " + teamName;
	}
}
