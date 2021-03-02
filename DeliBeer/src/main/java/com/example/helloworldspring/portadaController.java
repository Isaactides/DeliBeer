package com.example.helloworldspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class portadaController {
	
	@GetMapping("/portada")
	public String portada(Model model) {
		model.addAttribute("name", "World");
		model.addAttribute("hello", false);
		return "portada";
	}

}
