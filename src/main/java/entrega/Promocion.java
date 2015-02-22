package main.java.entrega;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;

@Entity
@Table(name="Promocion")
public class Promocion {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="montoOriginal")
	private String montoOriginal;
	
	@Column(name="montoOfertado")
	private String montoOfertado;
	
	@Column(name="periodoVigencia")
	private String periodoVigencia;
	
	@ElementCollection
	@CollectionTable(name="EnlacesWeb", joinColumns=@JoinColumn(name="id"))
	@Column(name="enlacesWeb")
	private List<String> enlacesWeb;
	
	@Column(name="calificacion")
	private float calificacion;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="promocion")
	private List<RedSocial> redesSociales;
	
	@ManyToOne()
	@JoinTable(
			name="Categoria_Promocion", 
			joinColumns = @JoinColumn(name="nombre"),
			inverseJoinColumns = @JoinColumn(name="id")
	)
	private Categoria categoria;
	
	@ManyToOne()
	@JoinTable(
			name="Promocion_Empresa", 
			joinColumns = @JoinColumn(name="id"),
			inverseJoinColumns = @JoinColumn(name="correoElectronico")
	)
	private Empresa empresa;
	
	@ManyToMany()
    @JoinTable(
            name="Usuario_Ciudad",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns=@JoinColumn(name="coordenadas")
    )
	private List<Ubicacion> ubicaciones;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.promocion")
	private List<Comparte> usuariosHanCompartido;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.promocion")
	private List<Compra> usuariosHanComprado;
	
	public Promocion() {}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMontoOriginal() {
		return montoOriginal;
	}

	public void setMontoOriginal(String montoOriginal) {
		this.montoOriginal = montoOriginal;
	}

	public String getMontoOfertado() {
		return montoOfertado;
	}

	public void setMontoOfertado(String montoOfertado) {
		this.montoOfertado = montoOfertado;
	}

	public String getPeriodoVigencia() {
		return periodoVigencia;
	}

	public void setPeriodoVigencia(String periodoVigencia) {
		this.periodoVigencia = periodoVigencia;
	}

	public List<String> getEnlacesWeb() {
		return enlacesWeb;
	}

	public void setEnlacesWeb(List<String> enlacesWeb) {
		this.enlacesWeb = enlacesWeb;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public List<RedSocial> getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(List<RedSocial> redesSociales) {
		this.redesSociales = redesSociales;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public List<Comparte> getUsuariosHanCompartido() {
		return usuariosHanCompartido;
	}

	public void setUsuariosHanCompartido(List<Comparte> usuariosHanCompartido) {
		this.usuariosHanCompartido = usuariosHanCompartido;
	}

	public List<Compra> getUsuariosHanComprado() {
		return usuariosHanComprado;
	}

	public void setUsuariosHanComprado(List<Compra> usuariosHanComprado) {
		this.usuariosHanComprado = usuariosHanComprado;
	}

}
