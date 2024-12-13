package com.wipro.training.customersoft.model;

import jakarta.persistence.*;
import lombok.Data;

/**
* Author  :rajgs
* Date    :13 Dec 2024
* Time    :12:46:05 pm
* Project :customer-demo
*/

@Entity
@Data
public class Customer {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long customerId;

	    private String firstName;

	    private String lastName;

	    @Lob
	    private byte[] passport;

	    @Lob
	    private byte[] image;

		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		}
	    
	    

}
