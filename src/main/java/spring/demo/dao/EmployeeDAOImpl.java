package spring.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import spring.demo.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addEmployee(Employee r) {
		Session session = this.sessionFactory.openSession();
		session.persist(r);
		session.beginTransaction().commit();
		System.out.println("saved successfully");

	}

	@Override
	public void updateEmployee(Employee r) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		return (Employee) sessionFactory.openSession().get(Employee.class, id);
		
	}

	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub

	}

}
