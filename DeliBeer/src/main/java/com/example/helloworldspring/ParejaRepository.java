package com.example.helloworldspring;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParejaRepository extends JpaRepository <PackCerveza, Long>{
	
	List<PackCerveza> findByNombre(String nombre);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}