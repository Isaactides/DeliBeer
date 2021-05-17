package dad.delibeer.repositories;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import dad.delibeer.model.PackCerveza;

@CacheConfig(cacheNames="packs")
public interface PackRepository extends JpaRepository <PackCerveza, Long>{
	
	@CacheEvict(allEntries=true)
	PackCerveza save(PackCerveza pack);
	
	@Cacheable
	List<PackCerveza> findByNombre(String nombre);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}