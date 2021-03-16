package com.example.helloworldspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class parejaController {
	
	@Autowired
	private ParejaRepository packs;
	private ComentarioRepository coment;
	
	@GetMapping("/paginainicio")
	public String mostrarPacks(Model model) {
		List<PackCerveza> pack = packs.findAll();
		model.addAttribute("pack", pack);
		return "paginainicio";
	}
	
	
	@GetMapping("/administrador")
	public String mostrarPacksAdmin(Model model) {
		List<PackCerveza> pack = packs.findAll();
		model.addAttribute("pack", pack);
		return "administrador";
	}
	
	@PostMapping("/ini")
	public String agregarComentario(Model model, Comentario coment, @RequestParam String tipo) {
		List<PackCerveza> pack = packs.findByNombre(tipo);
		PackCerveza cerve = pack.get(0);
		cerve.addComentario(coment);
		packs.save(cerve);
		List<Comentario> comentario = cerve.getComentarios();
		model.addAttribute("comentario", comentario);
		model.addAttribute("cerve", cerve);
		return "inicial";
	}
	
	
}
