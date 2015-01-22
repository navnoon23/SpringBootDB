package demo.service;

import java.util.List;

import demo.bean.Customer;


public interface CustomerService {
	
	List<Customer> findAll();
	
	void save(Customer customer);
	
	void deleteById(Long customerId);

}
