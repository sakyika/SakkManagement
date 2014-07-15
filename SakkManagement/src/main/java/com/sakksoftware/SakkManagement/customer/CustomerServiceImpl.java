package com.sakksoftware.SakkManagement.customer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public Customer create(Customer customer) {
		Customer createdCustomer = customer;
		return customerRepository.save(createdCustomer);
	}

	@Override
	@Transactional
	public Customer delete(int id) {
		Customer deletedCustomer = customerRepository.findOne(id);
		
		if(deletedCustomer == null){
			System.out.println("Cannot delete customer");
		}
		else{
			customerRepository.delete(deletedCustomer);
		}
		
		return deletedCustomer;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer update(Customer customer) {
		Customer updatedCustomer = customerRepository.findOne(customer.getId());
		
		if(updatedCustomer == null){
			System.out.println("Cannot update customer");
		}
		else{
			updatedCustomer.setAddress(customer.getAddress());
			updatedCustomer.setEmail(customer.getEmail());
			updatedCustomer.setFirst_name(customer.getFirst_name());
			updatedCustomer.setId(customer.getId());
			updatedCustomer.setLast_name(customer.getLast_name());
			updatedCustomer.setPhone_number(customer.getPhone_number());
			
			return updatedCustomer;
		}
		
		return null;
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findOne(id);
	}

}
