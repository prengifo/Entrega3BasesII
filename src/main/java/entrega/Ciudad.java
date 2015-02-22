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
import javax.persistence.ManyToMany;
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
	
	@ManyToMany()
    @JoinTable(
            name="Usuario_Ciudad",
            joinColumns={
                @JoinColumn(name="nombre"),
                @JoinColumn(name="radio"),
            },
            inverseJoinColumns=@JoinColumn(name="username")
    )
	private List<Usuario> usuarios;
	
	public Ciudad() {}

	public CiudadId getId() {
		return id;
	}

	public void setId(CiudadId id) {
		this.id = id;
	}

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

	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
