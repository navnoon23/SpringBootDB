package demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.bean.Customer;
import demo.repository.CustomerRepository;


@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		ArrayList<Customer> list = new ArrayList<Customer>();
		for(Customer c : customerRepository.findAll()) {
			list.add(c);
		}
		return list;
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public void deleteById(Long customerId) {
		customerRepository.deleteById(customerId);
	}

}
