package main.java.entrega;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RedSocial")
public class RedSocial {

	@Id
	@Column(name="url")
	private String url;
	
	@Column(name="servicio")
	private String servicio;
	
	@ManyToOne()
	@JoinTable(
			name="Usuario_RedSocial", 
			joinColumns = @JoinColumn(name="username"),
			inverseJoinColumns = @JoinColumn(name="url")
	)
	private Usuario usuario;
	
	private Promocion promocion;
	
	public RedSocial() {}

	public RedSocial(String servicio, String url) {
		super();
		this.servicio = servicio;
		this.url = url;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}