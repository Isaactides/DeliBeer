package dad.delibeer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dad.delibeer.model.PackCerveza;
import dad.delibeer.repositories.PackRepository;


@Controller
public class CompraController {
	
	@Autowired
	private PackRepository packs;
	
	@GetMapping("/compra")
	public String compra(Model model, @RequestParam String tipo) {
		List<PackCerveza> pack = packs.findByNombre(tipo);
		PackCerveza cerve = pack.get(0);
		double precio = cerve.getPrecio();
		model.addAttribute("tipo", tipo);
		model.addAttribute("precio", precio);
		
		return "compra";
	}
}
