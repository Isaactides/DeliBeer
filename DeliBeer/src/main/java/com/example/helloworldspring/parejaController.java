package com.example.helloworldspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class parejaController {
	
	@Autowired
	private ParejaRepository packs;
	
	@GetMapping("/pareja")
	public String pareja(Model model) {
		
		List<PackCerveza> pack = packs.findByNombre("pareja");
		PackCerveza cerve = pack.get(0);
		List<Comentario> comentarios = cerve.getComentarios();
		model.addAttribute("comentarios", comentarios);
		return "pareja";
	}
	
	@GetMapping("/inicial")
	public String inicial(Model model) {
		
		List<PackCerveza> pack = packs.findByNombre("inicial");
		PackCerveza cerve = pack.get(0);
		List<Comentario> comentarios = cerve.getComentarios();
		model.addAttribute("comentarios", comentarios);
		
		return "inicial";
	}
	
	@GetMapping("/profesional")
	public String profesional(Model model) {
		
		List<PackCerveza> pack = packs.findByNombre("profesional");
		PackCerveza cerve = pack.get(0);
		List<Comentario> comentarios = cerve.getComentarios();
		model.addAttribute("comentarios", comentarios);
		
		return "profesional";
	}
	
	@GetMapping("/fiesta")
	public String fiesta(Model model) {
		
		List<PackCerveza> pack = packs.findByNombre("fiesta");
		PackCerveza cerve = pack.get(0);
		List<Comentario> comentarios = cerve.getComentarios();
		model.addAttribute("comentarios", comentarios);
		
		return "fiesta";
	}

}
