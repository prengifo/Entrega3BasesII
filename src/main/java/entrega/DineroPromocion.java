package main.java.entrega;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dinero_promocion")
public class DineroPromocion {
	
	@Column(name="cantidad")
	private float cantidad;

	@Id
	@Column(name="username")
	private String username;
	
	public DineroPromocion() {}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
