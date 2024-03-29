package spring.demo.dao;

import java.util.List;

import spring.demo.model.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee r);

	public void updateEmployee(Employee r);

	public List<Employee> listEmployees();

	public Employee getEmployeeById(int id);

	public void removeEmployee(int id);
}
