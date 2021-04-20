package dad.delibeer.controllers;
import dad.delibeer.*;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dad.delibeer.model.Pedido;
import dad.delibeer.model.User;
import dad.delibeer.repositories.PedidoRepository;
import dad.delibeer.repositories.UserRepository;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;


@RequestMapping("/pedidos")
@Controller
public class PedidoController {
	@Autowired
	private PedidoRepository pedidos;
	
	@Autowired
	private UserRepository userRepository;
		
	@PostMapping("/pedidoaux")
	public String nuevoPedido(Model model, Pedido pedido, HttpServletRequest request) {
		User user=userRepository.findByName(request.getUserPrincipal().getName());
		pedidos.save(pedido);
		model.addAttribute("mail", user.getMail());
		model.addAttribute("pedido", pedido);
		ServicioInterno si = new ServicioInterno();
		
		si.enviar(pedido, user.getMail());
		si.recibir();
		return "comprado";	
	}
	
}
