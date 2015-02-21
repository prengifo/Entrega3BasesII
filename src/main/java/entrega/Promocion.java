package main.java.entrega;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@OneToMany(mappedBy = "pk.promocion", cascade=CascadeType.ALL)
	private List<Comparte> usuariosHanCompartido;
	
	public Promocion() {}


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
	
	

}
