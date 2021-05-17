package dad.delibeer.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dad.delibeer.model.User;
import dad.delibeer.repositories.UserRepository;

@Component
public class DataBaseUserLoader {
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	private void initDataBase() {
		
		if (userRepository.findByName("user") != null) {}
		else {
		userRepository.save(new User("user", "pass", "user@user.com", "ROLE_USER"));}
		
		if (userRepository.findByName("admin") != null) {}
		else {
		userRepository.save(new User("admin", "adminpass","admin@admin.com", "ROLE_ADMIN"));}
	}
	
}

