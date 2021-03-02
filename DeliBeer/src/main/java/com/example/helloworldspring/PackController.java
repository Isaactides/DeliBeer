package com.example.helloworldspring;

import java.net.URI;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/packs")
@Controller
public class PackController {
	
	@GetMapping("/basic")
	public String basic(Model model) {
		model.addAttribute("name", "World");
		model.addAttribute("hello", true);
		
		return "basic";
	}
	
	@Autowired
	private PackRepository packs;
	
	@Autowired
	private ComentarioRepository comentarios;
	
	@PostConstruct
	public void init() {
		//packs.save(new PackCerveza("Pareja", 2, 10));
		//packs.save(new PackCerveza("Inicial", 5, 22));
		PackCerveza p = new PackCerveza();
		p.setNombre("Pareja");
		p.setNumCervezas(2);
		p.setPrecio(10.0);
		p.addComentario(new Comentario("Maravillosa", 7));
		p.addComentario(new Comentario("nota mal", 5));
		
		packs.save(p);
		
		
		PackCerveza p1 = new PackCerveza();
		p1.setNombre("Inicial");
		p1.setNumCervezas(5);
		p1.setPrecio(22.0);
		p1.addComentario(new Comentario("Carisima", 3));
		p1.addComentario(new Comentario("me giusta", 6));
		
		packs.save(p1);
		
		PackCerveza p2 = new PackCerveza();
		p1.setNombre("Profesional");
		p1.setNumCervezas(8);
		p1.setPrecio(31.5);
		p1.addComentario(new Comentario("meh", 3));
		p1.addComentario(new Comentario("me agrada", 5));
		
		packs.save(p2);
		
		PackCerveza p3 = new PackCerveza();
		p1.setNombre("Fiesta");
		p1.setNumCervezas(10);
		p1.setPrecio(22.0);
		p1.addComentario(new Comentario("Tremendo fieston", 9));
		p1.addComentario(new Comentario("perfecto para un Project X, con pibitas", 10));
		
		packs.save(p3);
		
		
		
	}
	
	@GetMapping("/")
	public Collection<PackCerveza> getPacks() {
		return packs.findAll();
	}
	
	
	@GetMapping("/{id}")
	public PackCerveza getPack(@PathVariable long id){
		
		return packs.findById(id).orElseThrow();	
	}
	
	
	@PostMapping("/")
	public ResponseEntity<PackCerveza> createPack(@RequestBody PackCerveza pack){
		
		packs.save(pack);
		
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(pack.getId()).toUri();
	
		return ResponseEntity.created(location).body(pack);
	}
	
	@PutMapping("/{id}")
	public PackCerveza replacePack(@PathVariable long id,
			@RequestBody PackCerveza newPackCerveza) {
		
		PackCerveza pack = packs.findById(id).orElseThrow();
		
		newPackCerveza.setId(id);
		
		pack.getComentarios().forEach(c -> newPackCerveza.addComentario(c));
		
		packs.save(newPackCerveza);
		
		return newPackCerveza;
	}
	
	@DeleteMapping("/{id}")
	public PackCerveza deletePack(@PathVariable long id){
		PackCerveza pack = packs.findById(id).orElseThrow();
		
		packs.deleteById(id);
		
		return pack;
	}
	
	@GetMapping("/{idPack}/comentarios/{idComentario}")
	public Comentario getComentario(@PathVariable long idPack, @PathVariable long idComentario) {

		return comentarios.findById(idComentario).orElseThrow();
	}

	@PostMapping("/{idPack}/comentarios/")
	public ResponseEntity<Comentario> addComentario(@PathVariable long idPack, @RequestBody Comentario comentario) {

		PackCerveza pack = packs.findById(idPack).orElseThrow();

		comentario.setPack(pack);
		comentarios.save(comentario);

		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(comentario.getId()).toUri();

		return ResponseEntity.created(location).body(comentario);
	}

	@PutMapping("/{idPack}/comentarios/{idComentario}")
	public Comentario replaceComentario(@PathVariable long idPack, @PathVariable long idComentario,
			@RequestBody Comentario updatedComentario) {

		Comentario comentario = comentarios.findById(idComentario).orElseThrow();

		updatedComentario.setId(idComentario);
		
		updatedComentario.setPack(comentario.getPack());
		
		comentarios.save(updatedComentario);

		return updatedComentario;
	}

	@DeleteMapping("/{idPack}/comentarios/{idComentario}")
	public Comentario deleteComentario(@PathVariable long idPack, @PathVariable long idComentario) {

		Comentario comentario = comentarios.findById(idComentario).orElseThrow();

		comentarios.delete(comentario);

		return comentario;
	}
	

	
	
	@GetMapping("/greeting")
	public String greeting(Model model) {
		model.addAttribute("name", "World");
		model.addAttribute("hello", true);
		
		return "greeting_template";
	}

		
}
