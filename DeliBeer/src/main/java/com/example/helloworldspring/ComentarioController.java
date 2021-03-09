package com.example.helloworldspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ComentarioController {
	@Autowired
	private ComentarioRepository comentarios;
	
	
	@PostMapping("/comentarioaux")
	public void nuevoComentario(Model model, Comentario comentario) {
		comentarios.save(comentario);
		model.addAttribute("comentario", comentario);
		//return "comentado";
	}
}
