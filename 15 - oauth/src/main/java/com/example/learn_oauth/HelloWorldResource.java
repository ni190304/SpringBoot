package com.example.learn_oauth;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HelloWorldResource {

	@GetMapping("/")
	public String helloWorld(Authentication authentication) {
		System.out.println(authentication);
		System.out.println(authentication.getPrincipal());
		return "Hello WORLD";
	}
	
}