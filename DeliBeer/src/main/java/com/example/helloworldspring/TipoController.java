package com.example.helloworldspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TipoController {
	
	@Autowired
	private ParejaRepository packs;
	
	@GetMapping("/compra")
	public String compra(Model model, @RequestParam String tipo) {
		model.addAttribute("tipo", tipo);
		return "compra";
	}
	
	@GetMapping("/agregarcomentario")
	public String agregarComentario(Model model, @RequestParam String tipo) {
		model.addAttribute("tipo", tipo);
		return "agregarcomentario";
	}
	
	@PostMapping("/administrador")
	public String agregarPack(Model model, PackCerveza pack1) {
		packs.save(pack1);
		List<PackCerveza> pack = packs.findAll();
		model.addAttribute("pack", pack);
		return "administrador";
	}
}
