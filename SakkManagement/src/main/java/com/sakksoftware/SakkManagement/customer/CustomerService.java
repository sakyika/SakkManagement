package com.sakksoftware.SakkManagement.customer;

import java.util.List;

public interface CustomerService {
	
	public Customer create(Customer customer);
	public Customer delete(int id);
	public List<Customer> findAll();
	public Customer update(Customer customer);
	public Customer findById(int id);

}
