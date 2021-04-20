package dad.delibeer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dad.delibeer.model.Comentario;
import dad.delibeer.model.PackCerveza;
import dad.delibeer.model.User;
import dad.delibeer.repositories.ComentarioRepository;
import dad.delibeer.repositories.PackRepository;
import dad.delibeer.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private PackRepository packs;
	
	private ComentarioRepository coment;
	@Autowired
	private UserRepository users;
	
	private PasswordEncoder encoder;
	
	/*
	 * @GetMapping("/paginainicio") public String mostrarPacks(Model model) {
	 * List<PackCerveza> pack = packs.findAll(); model.addAttribute("pack", pack);
	 * return "paginainicio"; }
	 */
	
	@PostMapping("/nuevousuario")
	public String agregarUsuario(Model model, User usuario) {
		System.out.println(usuario.getName());
		System.out.println(usuario.getEncodedPassword());
		users.save(new User(usuario.getName(), usuario.getEncodedPassword(), usuario.getMail(),  "ROLE_USER"));
		model.addAttribute("usuario", usuario);
		return "comprobacion";	
	}
	
	@GetMapping("/agregarusu")
	public String agregarUsu(Model model) {
		return "agregarusu";
	}
}





