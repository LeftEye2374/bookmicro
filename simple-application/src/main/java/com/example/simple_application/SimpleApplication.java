package com.example.simple_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
@EnableDiscoveryClient
public class SimpleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

	public String helloRemoteServiceCall(String firstName, String lastName) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> restExchange =
				restTemplate.exchange(
						"http://logical-service-id/name/" + "{firstName}/{lastName}", HttpMethod.GET, null, String.class,
						firstName, lastName);
		return restExchange.getBody();
	}

	@GetMapping("/{firstName}")
	public String helloGET(@PathVariable String firstName, @RequestParam String lastName) {
		return String.format("{\"message\":\"Hello %s %s\"}",
				firstName, lastName);
	}
}
