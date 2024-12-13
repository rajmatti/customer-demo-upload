package com.wipro.training.customersoft.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.training.customersoft.model.Customer;
import com.wipro.training.customersoft.repository.CustomerRepository;

/**
* Author  :rajgs
* Date    :13 Dec 2024
* Time    :12:49:04 pm
* Project :customer-demo
*/

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
	


