package main.java.entrega;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Empresa")
public class Empresa {

	@Id
	@Column(name="correoElectronico")
	private String correoElectronico;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="contrasena")
	private String contrasena;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="numClientes")
	private int numClientes;
	
	@ManyToOne()
	@JoinTable(
			name="Categoria_Empresa", 
			joinColumns = @JoinColumn(name="nombre"),
			inverseJoinColumns = @JoinColumn(name="correoElectronico")
	)
	private Categoria categoria;
	
	public Empresa() {
	}

	public Empresa(String nombre, String correoElectronico, String contrasena,
			String telefono, String direccion, int numClientes) {
		super();
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.direccion = direccion;
		this.numClientes = numClientes;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumClientes() {
		return numClientes;
	}

	public void setNumClientes(int numClientes) {
		this.numClientes = numClientes;
	}
	
	
	
}