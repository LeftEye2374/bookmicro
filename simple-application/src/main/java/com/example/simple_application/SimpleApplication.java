package com.example.simple_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
public class SimpleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

	@GetMapping("/{firstName}")
	public String helloGET(@PathVariable String firstName, @RequestParam String lastName) {
		return String.format("{\"message\":\"Hello %s %s\"}",
				firstName, lastName);
	}
}
