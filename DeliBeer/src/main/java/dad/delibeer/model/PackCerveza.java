package dad.delibeer.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class PackCerveza {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private int numCervezas;
	private double precio;
	public String image;
	
	
	@Lob
	@JsonIgnore
	private Blob imageFile;
	
	@OneToMany(mappedBy = "pack", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentario> comentarios = new ArrayList<>();
	
	public PackCerveza() {	
	}
	
	public PackCerveza(String nombre, int numCervezas, double precio) {
		super();
		this.nombre = nombre;
		this.numCervezas = numCervezas;
		this.precio = precio;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumCervezas() {
		return numCervezas;
	}

	public void setNumCervezas(int numCervezas) {
		this.numCervezas = numCervezas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Blob getImageFile() {
		return imageFile;
	}

	public void setImageFile(Blob image) {
		this.imageFile = image;
	}
	
	@Override
	public String toString() {
		return "PackCerveza [id=" + id + ", nombre=" + nombre + ", numCervezas=" + numCervezas + ", precio=" + precio
				+ "]";
	}
	
	public void removeComentario(Comentario comentario) {
		comentarios.remove(comentario);
		comentario.setPack(null);
	}
	
	public void addComentario(Comentario comentario) {
		comentarios.add(comentario);
		comentario.setPack(this);
	}
	
	public List<Comentario> getComentarios(){
		return comentarios;
	}
	
}
