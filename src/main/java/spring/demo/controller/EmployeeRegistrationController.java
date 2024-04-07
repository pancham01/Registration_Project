package spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@RequestMapping("/list")
	public String listEmps(Model model) {
		List<Employee> list=employeeService.listEmployees();
		model.addAttribute("list",list);
		return "list";

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
	
//	editEmployee/${employee.id}
	  @RequestMapping("/editEmployee/{id}")
	    public String editEmployeeForm(@PathVariable("id") int id, Model model) {
		  System.out.println("EmployeeRegistrationController.editEmployeeForm()");
	        Employee employee = employeeService.getEmployeeById(id);
	        model.addAttribute("employee", employee);
	        return "editEmployee";
	    }

	    @RequestMapping("/editEmployee/{id}/edit")
	    public String editEmployeeSubmit(@PathVariable("id") int id, Employee employee) {
	       System.out.println("EmployeeRegistrationController.editEmployeeSubmit()");
	    	employee.setId(id); // Ensure the ID is set before saving
	        employeeService.updateEmployee(employee);
	        return "redirect:/list"; // Redirect to the list of employees after editing
	    }
	    
	    
	    
	    @RequestMapping("deleteEmployee/{id}")
	    public String deleteEmployee(@PathVariable int id, RedirectAttributes redirectAttributes) {
	        employeeService.removeEmployee(id);
	        redirectAttributes.addFlashAttribute("message", "Employee deleted successfully.");
	        return "redirect:/list";
	    }

}
