package com.luv2code.springdemo.dao;

import java.util.List;
import com.luv2code.springdemo.entity.*;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int theId);
}
