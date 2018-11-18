package com.secretsociyeti.budgetapp.users;

import java.util.concurrent.atomic.AtomicLong; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!"; 
	private final AtomicLong counter = new AtomicLong(); 
	
	@RequestMapping("/greeting") 
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) { 
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));	
	}
	
	@RequestMapping("/yeti") 
	public Greeting yeti(@RequestParam(value="name", defaultValue="Yeti") String name) { 
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));	
	}
	
	@RequestMapping("/login") 
	public String login(
			@RequestParam(value="name", defaultValue="name123") String name, 
			@RequestParam(value="password", defaultValue="password123") String password) {
		
		System.out.println(name);
		System.out.println(password);
		
		if (name.equals("name123") && password.equals("password123")) {
		return "success"; 
		}
		else {
			return "error"; 
		}
	}
}
