package com.luv2code.springdemo.mvc;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class SillyController {
	
	@RequestMapping("/showForm")
	public String silly() {
		return "helloword-form";
	}
}
