package com.example.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
public class ResourceServerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/")
	public String getWelcome() {
		return "welcome";
	}

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}

	@RolesAllowed("admin")
	@GetMapping("/goodbye")
	public String getGoodbye() {
		return "goodbye";
	}

	@PostAuthorize("(returnObject.name == authentication.name) or hasRole('admin')")
	@GetMapping("/customers/{username}")
	public Customer getCustomer(@PathVariable final String username) {
		return customerService.findByUsername(username);
	}

}
