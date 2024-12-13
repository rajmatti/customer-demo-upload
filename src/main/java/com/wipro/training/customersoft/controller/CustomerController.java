package com.wipro.training.customersoft.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wipro.training.customersoft.model.Customer;
import com.wipro.training.customersoft.service.CustomerService;

/**
 * Author  :rajgs
 * Date    :13 Dec 2024
 * Time    :12:52:13 pm
 * Project :customer-demo
 */
/*
 * File uploads are a common requirement in web applications, 
 * Spring Boot makes it easy to handle file uploads with its built-in support 
 * for multipart file upload.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/*
	 *   //Open Postman & make POST request - http://localhost:8088/api/customers
	 *   
	 *   Go to the Body tab. Select the form-data option.
	 *	Add the following fields:
	 *
	 * Key: firstName Type: Text Value: Enter the first name (e.g., Rod).
	 * Key: lastName Type: Text Value: Enter the last name (e.g., Johnson).
	 * Key: passport Type: File Value: Upload a PDF file of the passport.
     * Key: image Type: File Value: Upload a JPEG image for the profile.
	 */

	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("passport") MultipartFile passport,
			@RequestParam("image") MultipartFile image) {
		try {
			Customer customer = new Customer();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setPassport(passport.getBytes());
			customer.setImage(image.getBytes());

			return ResponseEntity.ok(customerService.saveCustomer(customer));
		} catch (IOException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	//Open Postman & make GET request - http://localhost:8088/api/customers/2
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
		return customerService.getCustomerById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	//Open Postman & make GET request - http://localhost:8088/api/customers
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		if (customers.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(customers);
	}


}
