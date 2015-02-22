package main.java.entrega;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TarjetaDeCredito")
public class TarjetaDeCredito {
	
	@Id
	@Column(name="numeroTarjeta")
	private String numeroTarjeta;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="fechaDeVencimiento")
	private String fechaDeVencimiento;
	
	@Column(name="codigoSeguridad")
	private int codigoSeguridad;
	
	@ManyToOne
	@JoinTable(
			name="Usuario_TarjetaCredito", 
			joinColumns = @JoinColumn(name="username"),
			inverseJoinColumns = @JoinColumn(name="numeroTarjeta")
	)
	private Usuario usuario;
	
	public TarjetaDeCredito() {}

	public TarjetaDeCredito(String nombre, String fechaDeVencimiento,
			int codigoSeguridad) {
		super();
		this.nombre = nombre;
		this.fechaDeVencimiento = fechaDeVencimiento;
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(String fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
