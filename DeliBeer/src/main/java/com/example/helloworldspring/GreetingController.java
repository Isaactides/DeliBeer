package com.example.helloworldspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
	
	@GetMapping("/hola")
	public String hola() {
		return "hola.html";
	}
	
	@GetMapping("/greeting")
	public String greeting(Model model) {
		model.addAttribute("name", "World");
		
		return "greeting_template";
	}
	
	@GetMapping("/basic")
	public String basic(Model model) {
		model.addAttribute("name", "Ivan");
		model.addAttribute("hello", false);
		
		return "basic";
	}
	
}
