package com.example.helloworldspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class parejaController {
	
	
	@GetMapping("/pareja")
	public String pareja(Model model) {
		
		return "pareja";
	}

}
