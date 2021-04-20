package dad.delibeer.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import dad.delibeer.model.PackCerveza;


public interface PackRepository extends JpaRepository <PackCerveza, Long>{
	
	List<PackCerveza> findByNombre(String nombre);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}