package dad.delibeer.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import dad.delibeer.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
