package main.java.entrega;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="correoElectronico")
	private String correoElectronico;
	
	@Column(name="contrasena")
	private String contrasena;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="frecuenciaCorreos")
	private String frecuenciaCorreos;
	
	@OneToOne(cascade=CascadeType.ALL)
	@MapsId
	private DineroPromocion saldoPromocion;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="usuario")
	private List<TarjetaDeCredito> tarjetasDeCredito;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="usuario")
	private List<RedSocial> redesSociales;
	
	@ManyToMany()
    @JoinTable(
            name="Usuario_Categorias",
            joinColumns=@JoinColumn(name="username"),
            inverseJoinColumns=@JoinColumn(name="nombre")
    )
	private List<Categoria> categoriasPreferidas;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="usuarios")
	private List<Ciudad> ciudadesPreferidas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.usuario", cascade=CascadeType.ALL)
	private List<Comparte> promocionesCompartidas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.usuario", cascade=CascadeType.ALL)
	private List<Compra> promocionesAdquiridas;
	
	public Usuario() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFrecuenciaCorreos() {
		return frecuenciaCorreos;
	}

	public void setFrecuenciaCorreos(String frecuenciaCorreos) {
		this.frecuenciaCorreos = frecuenciaCorreos;
	}

	public DineroPromocion getSaldoPromocion() {
		return saldoPromocion;
	}

	public void setSaldoPromocion(DineroPromocion saldoPromocion) {
		this.saldoPromocion = saldoPromocion;
	}

	public List<TarjetaDeCredito> getTarjetasDeCredito() {
		return tarjetasDeCredito;
	}

	public void setTarjetasDeCredito(List<TarjetaDeCredito> tarjetasDeCredito) {
		this.tarjetasDeCredito = tarjetasDeCredito;
	}

	public List<RedSocial> getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(List<RedSocial> redesSociales) {
		this.redesSociales = redesSociales;
	}

	public List<Categoria> getCategoriasPreferidas() {
		return categoriasPreferidas;
	}

	public void setCategoriasPreferidas(List<Categoria> categoriasPreferidas) {
		this.categoriasPreferidas = categoriasPreferidas;
	}

	public List<Ciudad> getCiudadesPreferidas() {
		return ciudadesPreferidas;
	}

	public void setCiudadesPreferidas(List<Ciudad> ciudadesPreferidas) {
		this.ciudadesPreferidas = ciudadesPreferidas;
	}

	public List<Comparte> getPromocionesCompartidas() {
		return promocionesCompartidas;
	}

	public void setPromocionesCompartidas(List<Comparte> promocionesCompartidas) {
		this.promocionesCompartidas = promocionesCompartidas;
	}

	public List<Compra> getPromocionesAdquiridas() {
		return promocionesAdquiridas;
	}

	public void setPromocionesAdquiridas(List<Compra> promocionesAdquiridas) {
		this.promocionesAdquiridas = promocionesAdquiridas;
	}
	
	
	

}
