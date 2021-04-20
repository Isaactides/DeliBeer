package dad.delibeer.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import dad.delibeer.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

}
