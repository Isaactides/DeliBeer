package com.example.helloworldspring;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.helloworldspring.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
}
