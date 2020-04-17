package com.luv2code.springboot.demo.springbootmycoolapp.rest;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	@GetMapping("/")
	public String sayHello() {
		return "Hello World ! Time on server is " + LocalDate.now();
	}
}
