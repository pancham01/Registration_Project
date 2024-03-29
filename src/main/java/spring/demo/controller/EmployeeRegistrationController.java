package spring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.demo.model.Employee;
import spring.demo.service.EmployeeService;

@Controller
public class EmployeeRegistrationController {

	private EmployeeService employeeService;

	@Autowired(required = true)
	@Qualifier(value = "employeeService")
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/")
	public String display() {
		return "index2";
	}

//	@RequestMapping("/registration-form")
//	public String read() {
//		System.out.println("SURE<<<<<<<<<<>>>>>>>>>>>");
//		return "registration";
//	}

	@RequestMapping("/searchEmp")
	public String searchEmployee(@RequestParam int id, Model model) {
		Employee emp = employeeService.getEmployeeById(id);
		if (emp != null) {
			model.addAttribute("emp", emp);
			return "done";
		}

		model.addAttribute("id", id);
		return "error";

	}

	@RequestMapping("/find")
	public String searchMethod() {

		return "search";

	}

	@RequestMapping("/registration-form")
	public String model(Model model) {
		model.addAttribute("emp", new Employee());
		return "registration";
	}

	@RequestMapping("/registerEmp")
	public String registered(@ModelAttribute Employee emp) {
		employeeService.addEmployee(emp);
		System.out.println(emp);
		System.out.println();
		return "registered";
	}

}
