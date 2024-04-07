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
		System.out.println("EmployeeDAOImpl.updateEmployee()");
		 Session session = sessionFactory.openSession();
	        session.update(r);
			session.beginTransaction().commit();

	        
	}

	@Override
	public List<Employee> listEmployees() {
		Session session = sessionFactory.openSession();
        return session.createQuery("from Employee").list();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return (Employee) sessionFactory.openSession().get(Employee.class, id);
		
	}

	@Override
	public void removeEmployee(int id) {
		Session session =sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class, id);
        if (employee != null) {
            session.delete(employee);
            session.beginTransaction().commit();
        }
        System.out.println(employee+" Deleted Successfull");
	}

}
