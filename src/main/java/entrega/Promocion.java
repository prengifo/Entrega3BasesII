package main.java.entrega;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Promocion")
public class Promocion {
	
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
	
	@Column(name="enlacesWeb")
	private List<String> enlacesWeb;
	
	@Column(name="calificacion")
	private float calificacion;
	
	public Promocion() {}

	public Promocion(String nombre, String descripcion, String montoOriginal,
			String montoOfertado, String periodoVigencia,
			List<String> enlacesWeb, float calificacion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.montoOriginal = montoOriginal;
		this.montoOfertado = montoOfertado;
		this.periodoVigencia = periodoVigencia;
		this.enlacesWeb = enlacesWeb;
		this.calificacion = calificacion;
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
	
	

}
