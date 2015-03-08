package main.java.entrega.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categoria")
public class Categoria {

	@Id
	@Column(name="cantidad")
	private String nombre;
	
	@ManyToOne()
	@JoinColumn(name="nombre_hijo")
	private Categoria categoriaPadre;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="categoriaPadre")
	private List<Categoria> subcategoria;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="categoria")
	private List<Empresa> empresas;
	
	@ManyToMany()
    @JoinTable(
            name="Usuario_Categorias",
            joinColumns=@JoinColumn(name="username"),
            inverseJoinColumns=@JoinColumn(name="nombre")
    )
	private List<Usuario> usuarios;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="categoria")
	private List<Promocion> promociones;

	public Categoria() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoriaPadre() {
		return categoriaPadre;
	}

	public void setCategoriaPadre(Categoria categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
	}

	public List<Categoria> getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(List<Categoria> subcategoria) {
		this.subcategoria = subcategoria;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}
}
