package dad.delibeer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dad.delibeer.model.Comentario;
import dad.delibeer.model.PackCerveza;
import dad.delibeer.repositories.PackRepository;

@Controller
public class VisPackController {
	
	
	@Autowired
	private PackRepository packs;
	
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
	
	@GetMapping("/administrador")
	public String mostrarPacksAdmin(Model model, HttpServletRequest request) {
		List<PackCerveza> pack = packs.findAll();
		model.addAttribute("pack", pack);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "/administrador";
	}
	
	@PostMapping("/administrador")
	public String agregarPack(Model model, PackCerveza pack1, HttpServletRequest request) {
		packs.save(pack1);
		List<PackCerveza> pack = packs.findAll();
		model.addAttribute("pack", pack);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "administrador";
	}
	
	@GetMapping("/anadirpack")
	public String anadirpack(Model model) {
		
		return "anadirpack";
	}
	
	
	
}
