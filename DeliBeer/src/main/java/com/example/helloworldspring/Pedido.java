package com.example.helloworldspring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	String Nombre;
	String Apellidos;
	String Direccion;
	int Telefono;
	int AñoNacimiento;

	
	public Pedido(String nombre, String apellidos, String direccion, int telefono, int año) {
		super();
		this.Nombre=nombre;
		this.Apellidos=apellidos;
		this.Direccion=direccion;
		this.Telefono=telefono;
		this.AñoNacimiento=año;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public int getAñoNacimiento() {
		return AñoNacimiento;
	}

	public void setAñoNacimiento(int añoNacimiento) {
		AñoNacimiento = añoNacimiento;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Direccion=" + Direccion
				+ ", Telefono=" + Telefono + ", AñoNacimiento=" + AñoNacimiento + "]";
	}
	
	
	
}
