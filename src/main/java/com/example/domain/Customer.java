package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	
	private String name;
	private String email;
	private String mobile;

}
