package dad.delibeer.controllers;

import java.io.IOException;
import java.net.URI;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dad.delibeer.model.Comentario;
import dad.delibeer.model.PackCerveza;
import dad.delibeer.model.User;
import dad.delibeer.repositories.ComentarioRepository;
import dad.delibeer.repositories.PackRepository;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/packs")
@Controller
public class InitPackController {
	
	
	@Autowired
	private PackRepository packs;
	
	@Autowired
	private ComentarioRepository comentarios;
	
	@PostConstruct
	public void init() {
		PackCerveza p = new PackCerveza();
		p.setNombre("Pareja");
		p.setNumCervezas(2);
		p.setPrecio(10.0);
		p.addComentario(new Comentario("No me gusta esta cerveza", 3));
		p.addComentario(new Comentario("No esta mal", 5));
		
		packs.save(p);
		
		
		PackCerveza p1 = new PackCerveza();
		p1.setNombre("Inicial");
		p1.setNumCervezas(5);
		p1.setPrecio(22.0);
		p1.addComentario(new Comentario("Carisima", 3));
		p1.addComentario(new Comentario("Me gusta", 6));
		
		packs.save(p1);
		
		PackCerveza p2 = new PackCerveza();
		p2.setNombre("Profesional");
		p2.setNumCervezas(8);
		p2.setPrecio(31.5);
		p2.addComentario(new Comentario("Un poco mala", 3));
		p2.addComentario(new Comentario("Me agrada", 5));
		
		packs.save(p2);
		
		PackCerveza p3 = new PackCerveza();
		p3.setNombre("Fiesta");
		p3.setNumCervezas(10);
		p3.setPrecio(22.0);
		p3.addComentario(new Comentario("Que buena fiesta con estas cervezas", 9));
		p3.addComentario(new Comentario("Perfecto para pasarlo bien con los amigos", 10));
		
		packs.save(p3);
		
		
	}
			
}