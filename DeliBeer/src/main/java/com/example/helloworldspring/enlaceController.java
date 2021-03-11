package com.example.helloworldspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class enlaceController {
	
	
	@Autowired
	private ParejaRepository packs;
	
	@GetMapping("/inicial")
	public String inicial(Model model, @RequestParam String tipo) {
		
		List<PackCerveza> pack = packs.findByNombre(tipo);
		PackCerveza cerve = pack.get(0);
		List<Comentario> comentario = cerve.getComentarios();
		model.addAttribute("comentario", comentario);
		model.addAttribute("cerve", cerve);
		return "inicial";
	}
	
	@GetMapping("/inicialadmin")
	public String inicialadmin(Model model, @RequestParam String tipo) {
		
		List<PackCerveza> pack = packs.findByNombre(tipo);
		PackCerveza cerve = pack.get(0);
		List<Comentario> comentario = cerve.getComentarios();
		model.addAttribute("comentario", comentario);
		model.addAttribute("cerve", cerve);
		return "inicialadmin";
	}
	
	@GetMapping("/anadirpack")
	public String anadirpack(Model model) {
		
		return "anadirpack";
	}
	
}
