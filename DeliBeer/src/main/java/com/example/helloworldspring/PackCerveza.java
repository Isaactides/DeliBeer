package com.example.helloworldspring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PackCerveza {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private int numCervezas;
	private Long precio;
	
	public PackCerveza() {	
	}
	
	public PackCerveza(String nombre, int numCervezas, long precio) {
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

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "PackCerveza [id=" + id + ", nombre=" + nombre + ", numCervezas=" + numCervezas + ", precio=" + precio
				+ "]";
	}
	
	
	
}
