package luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		employees = new ArrayList<>();
		
		employees.add(new Employee(1, "Le", "Quang Duy", "quangduynb00@gmail.com"));
		employees.add(new Employee(2,"Le", "Quang", "quangduynb00@outlook.com"));
		employees.add(new Employee(2,"Le", "Duy", "quangduynb@gmail.com"));
	}
	
	@GetMapping("/list")
	public String showList(Model model) {
		model.addAttribute("employees", employees);
		return "list-employees";
	}
}
