package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWordController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloword-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloword";
	}
	
	@RequestMapping("processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		String theName = request.getParameter("studentName");
		
		theName = theName.toUpperCase();
		
		model.addAttribute("message",theName);
		
		return "helloword";
	}
}
