package main.java.entrega;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Compra")
@AssociationOverrides({
    @AssociationOverride(name = "pk.usuario", 
        joinColumns = @JoinColumn(name = "username")),
    @AssociationOverride(name = "pk.promocion", 
        joinColumns = @JoinColumn(name = "id")) })
public class Compra {

	@EmbeddedId
	private CompraId pk;
	
	@Column(name="compartido")
	private boolean compartido;
	
	@Column(name="metodoPago")
	private String metodoPago;
	
	@Column(name="destinatario")
	private String destinatario;
	
	public CompraId getPk() {
		return pk;
	}
	
	public void setPk(CompraId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Usuario getUsuario() {
		return getPk().getComprador();
	}
 
	public void setUsuario(Usuario usuario) {
		getPk().setComprador(usuario);
	}
	
	@Transient
	public Promocion getPromocion() {
		return getPk().getPromocion();
	}
 
	public void setPromocion(Promocion promocion) {
		getPk().setPromocion(promocion);
	}
}

@Embeddable
class CompraId implements Serializable {
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Promocion promocion;

	public Usuario getComprador() {
		return usuario;
	}

	public void setComprador(Usuario usuario) {
		this.usuario = usuario;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}	
	
}
