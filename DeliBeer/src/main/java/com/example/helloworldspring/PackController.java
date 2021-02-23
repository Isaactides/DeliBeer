package com.example.helloworldspring;

import java.net.URI;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Autowired
	private PackRepository packs;
	
	@PostConstruct
	public void init() {
		packs.save(new PackCerveza("Pareja", 2, 10));
		packs.save(new PackCerveza("Inicial", 5, 22));
	}
	
	@GetMapping("/")
	public Collection<PackCerveza> getPacks() {
		return packs.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PackCerveza> getPack(@PathVariable long id){
		Optional<PackCerveza> pack = packs.findById(id);
		
		if(pack.isPresent()) {
			return ResponseEntity.ok(pack.get());
		} else {
			return ResponseEntity.notFound().build();
		}		
	}
	
	
	@PostMapping("/")
	public ResponseEntity<PackCerveza> createPost(@RequestBody PackCerveza pack){
		
		packs.save(pack);
		
		URI location = fromCurrentRequest().path("/{id}").buildAndExpand(pack.getId()).toUri();
	
		return ResponseEntity.created(location).body(pack);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PackCerveza> replacePackCerveza(@PathVariable long id,
			@RequestBody PackCerveza newPackCerveza) {
		
		Optional<PackCerveza> pack = packs.findById(id);
		
		if (pack.isPresent()) {
			newPackCerveza.setId(id);
			packs.save(newPackCerveza);
			return ResponseEntity.ok(newPackCerveza);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PackCerveza> deletePost(@PathVariable long id){
		Optional<PackCerveza> pack = packs.findById(id);
		
		if(pack.isPresent()) {
			packs.deleteById(id);
			return ResponseEntity.ok(pack.get());
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
		
}
