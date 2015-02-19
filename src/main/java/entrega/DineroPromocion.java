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
	private String username;
	public DineroPromocion() {}

	public DineroPromocion(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
