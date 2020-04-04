package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the sessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	// Needn't @transactional
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		// sort by lastName
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		// Save or update ( Amazing hibernate :)) )
		session.saveOrUpdate(customer);
		
		// Not close, because @reposity will do that
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Customer theCustomer = session.get(Customer.class,theId);
		return theCustomer;
	}

	@Override
	public void customerDelete(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Customer theCustomer = session.get(Customer.class, theId);
		session.delete(theCustomer);
	}

}
