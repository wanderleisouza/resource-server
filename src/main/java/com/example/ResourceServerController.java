package com.example;

import javax.annotation.security.RolesAllowed;

import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceServerController {

	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}

	@RolesAllowed("admin")
	@GetMapping("/goodbye")
	public String getGoodbye() {
		return "goodbye";
	}

	@GetMapping("/userinfo")
	public String me(Authentication authentication) {
		var username = authentication.getName();
		SimpleKeycloakAccount details = (SimpleKeycloakAccount)authentication.getDetails();
		String clientId = details.getKeycloakSecurityContext().getDeployment().getResourceName();
		return username.concat("@").concat(clientId);
	}
	
}
