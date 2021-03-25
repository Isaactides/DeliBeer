package com.example.helloworldspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class WebController {
	@RequestMapping("/login")
	public String home(Model model, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "login";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}
}