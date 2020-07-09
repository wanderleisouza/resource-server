package com.example;

import javax.annotation.security.RolesAllowed;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceServerController {

	@GetMapping("/public")
	public String getPublicResource() {
		return "This is a public resource";
	}

	@RolesAllowed("admin")
	@GetMapping("/protected")
	public String getProtectedResource() {
		return "This is a protected resource";
	}

}
