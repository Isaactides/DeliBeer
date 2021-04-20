package dad.delibeer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dad.delibeer.model.Comentario;
import dad.delibeer.model.PackCerveza;
import dad.delibeer.repositories.ComentarioRepository;
import dad.delibeer.repositories.PackRepository;


@Controller
public class ComentarioController {
	@Autowired
	private ComentarioRepository coment;
	
	@Autowired
	private PackRepository packs;
	
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
	
	@GetMapping("/agregarcomentario")
	public String agregarComentario(Model model, @RequestParam String tipo) {
		model.addAttribute("tipo", tipo);
		return "agregarcomentario";
	}
}
