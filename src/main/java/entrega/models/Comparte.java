package main.java.entrega.models;

import java.beans.Transient;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Comparte")
@AssociationOverrides({
    @AssociationOverride(name = "pk.usuario", 
        joinColumns = @JoinColumn(name = "username")),
    @AssociationOverride(name = "pk.promocion", 
        joinColumns = @JoinColumn(name = "id")) })
public class Comparte {
	
	@EmbeddedId
	private ComparteId pk;
	
	@ElementCollection
	@Column(name="destinatarios")
	private List<String> destinatarios;

	public ComparteId getPk() {
		return pk;
	}

	public void setPk(ComparteId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Usuario getUsuario() {
		return getPk().getRemitente();
	}
 
	public void setUsuario(Usuario usuario) {
		getPk().setRemitente(usuario);
	}
	
	@Transient
	public Promocion getPromocion() {
		return getPk().getPromocionCompartida();
	}
 
	public void setPromocion(Promocion promocion) {
		getPk().setPromocionCompartida(promocion);
	}

	public List<String> getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(List<String> destinatarios) {
		this.destinatarios = destinatarios;
	}
	
	

}
