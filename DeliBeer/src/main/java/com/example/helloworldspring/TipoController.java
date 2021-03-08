package com.example.helloworldspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TipoController {
	@GetMapping("/compra")
	public String compra(Model model, @RequestParam String tipo) {
		model.addAttribute("tipo", tipo);
		return "compra";
	}
}
