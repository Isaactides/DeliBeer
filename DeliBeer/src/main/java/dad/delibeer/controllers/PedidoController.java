package dad.delibeer.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import dad.delibeer.model.Pedido;
import dad.delibeer.model.User;
import dad.delibeer.repositories.PedidoRepository;
import dad.delibeer.repositories.UserRepository;



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
		String nombre = pedido.getNombre();
		String apellido = pedido.getApellidos();
		String tipo = pedido.getTipo_pedido();
		Double precio = pedido.getPrecio_pedido();
		
		si.enviar(nombre, apellido, tipo, precio, user.getMail());
		
		return "comprado";	
	}
	
}
