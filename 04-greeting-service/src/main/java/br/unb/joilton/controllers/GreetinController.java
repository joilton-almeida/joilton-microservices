package br.unb.joilton.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unb.joilton.configuration.GreetingConfiguration;
import br.unb.joilton.model.Greeting;

@RestController
public class GreetinController {
	
	private final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	GreetingConfiguration configuration;
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
		
		if (name.isEmpty()) {
			
			name = configuration.getDefaultValue();
			
		}
		
		return new Greeting(counter.incrementAndGet(), String.format(template, configuration.getGreeting(), name));
	}
	

}
