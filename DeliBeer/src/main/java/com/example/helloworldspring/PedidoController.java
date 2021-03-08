package com.example.helloworldspring;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;


@RestController
@RequestMapping("/pedidos")
@Controller
public class PedidoController {
	@Autowired
	private PedidoRepository pedidos;
	
	@GetMapping("/")
	public Collection<Pedido> getPedidos() {
		return pedidos.findAll();
	}
	
	@GetMapping("/{id}")
	public Pedido getPedidos(@PathVariable long id){
		
		return pedidos.findById(id).orElseThrow();	
	}
	
	
	
	@PostMapping("/pedido/new")
	public String newPedido(Model model, Pedido pedido) {
		pedidos.save(pedido);
		return "savepedido";
	}
	
	
	@PutMapping("/{id}")
	public Pedido replacePedido(@PathVariable long id,
			@RequestBody Pedido newPedido) {
		
		Pedido pedido = pedidos.findById(id).orElseThrow();
		
		newPedido.setId(id);
				
		pedidos.save(newPedido);
		
		return newPedido;
	}
}
