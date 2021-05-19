package com.candidjava.spring.boot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user")
	String home() {
		System.out.println("Hey Thereeeee");
		return "Hello  world";
	}
	
	@GetMapping("/")
	String home1() {
		System.out.println("Hey Thereeeee1111");
		return "Hello  world11111";
	}

}
