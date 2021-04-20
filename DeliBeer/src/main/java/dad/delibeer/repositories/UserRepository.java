package dad.delibeer.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import dad.delibeer.model.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByName(String name);
	
}
