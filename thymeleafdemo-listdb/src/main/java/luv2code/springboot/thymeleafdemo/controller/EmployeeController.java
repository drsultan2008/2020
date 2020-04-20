package luv2code.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import luv2code.springboot.thymeleafdemo.entity.Employee;
import luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String showList(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "/employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee theEmployee = new Employee();
		model.addAttribute("employee",theEmployee);
		
		return "/employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		// Get the employee
		Employee employee = employeeService.findById(id);
		// Set attribute
		model.addAttribute("employee",employee);
		
		return "/employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}
