package spring.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.demo.model.Employee;

@Controller
public class WelcomeController {
	List<Employee> list = new LinkedList<>();

//	@ResponseBody
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
	public String searchEmployee(@RequestParam String name, Model model) {
		for (Employee employee : list) {
			if (employee.getName().equals(name)) {
				model.addAttribute("emp",employee);
				return "done";
			}
		}
		model.addAttribute("name",name);
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
		list.add(emp);
		System.out.println(emp);
		System.out.println();
		return "registered";
	}

//	@RequestMapping("/registerEmp")
//	public String showFeatures(@RequestParam String name, @RequestParam String gender, @RequestParam int age,
//			@RequestParam int salary) {
	
	
//		System.out.println(name);
//		System.out.println(gender);
//		System.out.println(age);
//		System.out.println(salary);
//		return "done";
//	}

}
