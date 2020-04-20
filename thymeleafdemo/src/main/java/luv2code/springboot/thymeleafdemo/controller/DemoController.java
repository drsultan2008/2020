package luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
public class DemoController {
	
	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("date", new java.util.Date());
		return "helloworld";
	}
	
}
