package dad.delibeer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	String nombre;
	String apellidos;
	String direccion;
	String tipo_pedido;
	int telefono;
	int anio;
	double precio_pedido;

	public Pedido() {
		
	}
	
	public Pedido(String nombre, String apellidos, String direccion, String tipo_pedido, int telefono, int anio, double precio_pedido) {
		super();
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.direccion=direccion;
		this.tipo_pedido=tipo_pedido;
		this.telefono=telefono;
		this.anio=anio;
		this.precio_pedido = precio_pedido;
	}

	public double getPrecio_pedido() {
		return precio_pedido;
	}

	public void setPrecio_pedido(double precio_pedido) {
		this.precio_pedido = precio_pedido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getTipo_pedido() {
		return tipo_pedido;
	}

	public void setTipo_pedido(String tipo_pedido) {
		this.tipo_pedido = tipo_pedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", Nombre=" + nombre + ", Apellidos=" + apellidos + ", Direccion=" + direccion
				+ ", Telefono=" + telefono + ", AñoNacimiento=" + anio + "]";
	}
	
	
	
}
