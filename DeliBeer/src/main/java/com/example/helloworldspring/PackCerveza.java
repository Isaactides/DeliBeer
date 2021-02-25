package com.example.helloworldspring;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class PackCerveza {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private int numCervezas;
	private double precio;
	
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
