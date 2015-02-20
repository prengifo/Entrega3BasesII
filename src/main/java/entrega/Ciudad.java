package main.java.entrega;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ciudad")
public class Ciudad {
	
	@EmbeddedId
	CiudadId id;
	
	@Column(name="numeroPromociones")
	private int numeroPromociones;
	
	@Column(name="calificacion")
	private float calificacion;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="ciudad")
	private List<Ubicacion> ubicaciones;
	
	public Ciudad() {}

	public int getNumeroPromociones() {
		return numeroPromociones;
	}

	public void setNumeroPromociones(int numeroPromociones) {
		this.numeroPromociones = numeroPromociones;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}
	
	
}

@Embeddable
class CiudadId implements Serializable {
	private String nombre;
	private String radio;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}
}
