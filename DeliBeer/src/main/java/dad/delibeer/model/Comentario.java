package dad.delibeer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String texto;
	private int valoracion;
	
	@ManyToOne
	@JsonIgnore
	private PackCerveza pack;
	
	public Comentario() {
		
		
	}

	public Comentario(String texto, int valoracion) {
		super();
		this.texto = texto;
		this.valoracion = valoracion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public PackCerveza getPack() {
		return pack;
	}
	
	public void setPack(PackCerveza pack) {
		this.pack = pack;
	}
	
	
}
