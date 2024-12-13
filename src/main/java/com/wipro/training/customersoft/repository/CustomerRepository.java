package com.wipro.training.customersoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.training.customersoft.model.Customer;

/**
* Author  :rajgs
* Date    :13 Dec 2024
* Time    :12:48:20 pm
* Project :customer-demo
*/

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
