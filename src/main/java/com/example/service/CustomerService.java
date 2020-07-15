package com.example.service;

import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.exception.CustomerNotFoundException;

@Service
public class CustomerService {

	public Customer findByUsername(String username) {

		switch (username) {
		case "jane-doe":
			return new Customer("jane-doe", "jane-doe@mailserver.com", "867-5309");
		case "john-doe":
			return new Customer("john-doe", "john-doe@mailserver.com", "735-5507");
		case "chuck-norris":
			return new Customer("chuck-norris", "chuck-norris@mailserver.com", "911");
		default:
			throw new CustomerNotFoundException();
		}

	}

}
