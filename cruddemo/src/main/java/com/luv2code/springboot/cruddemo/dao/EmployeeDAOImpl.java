package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// Define field for entityManager
	private EntityManager entityManager;
	
	// Set up constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// Get the current session
		Session session = entityManager.unwrap(Session.class);
		// Create a query
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		// Execute query and get result\
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// Get current session
		Session session = entityManager.unwrap(Session.class);
		// Get employ
		Employee employee = session.get(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		// Update or save
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
//		Query query = session.createQuery("delete from Employee where id:=employeeId");
//		query.setParameter("employeeId",id);
//		
//		query.executeUpdate();
		session.delete(session.get(Employee.class, id));
	}

}
