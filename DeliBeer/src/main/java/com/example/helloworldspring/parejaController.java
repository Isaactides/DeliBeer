package com.example.helloworldspring;

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
		
		PackCerveza pack = packs.findByNombre("pareja");
		List<Comentarios> comentarios = pack.getComentarios();
		model.addAtribute("comentarios", comentarios);
		return "pareja";
	}
	
	@GetMapping("/inicial")
	public String inicial(Model model) {
		
		return "inicial";
	}
	
	@GetMapping("/profesional")
	public String profesional(Model model) {
		
		return "profesional";
	}
	
	@GetMapping("/fiesta")
	public String fiesta(Model model) {
		
		return "fiesta";
	}

}
