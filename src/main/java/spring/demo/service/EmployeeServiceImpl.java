package spring.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.demo.dao.EmployeeDAO;
import spring.demo.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;
	
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public void addEmployee(Employee r) {
		this.employeeDAO.addEmployee(r);
		
	}

	@Override
	@Transactional
	public void updateEmployee(Employee r) {
		this.employeeDAO.updateEmployee(r);
		
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return employeeDAO.listEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

}
