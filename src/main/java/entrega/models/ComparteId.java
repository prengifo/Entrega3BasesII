package main.java.entrega.models;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by patrickrengifo on 3/8/15.
 */
@Embeddable
public class ComparteId implements Serializable {

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Promocion promocion;

    public Usuario getRemitente() {
        return usuario;
    }

    public void setRemitente(Usuario usuario) {
        this.usuario = usuario;
    }

    public Promocion getPromocionCompartida() {
        return promocion;
    }

    public void setPromocionCompartida(Promocion promocion) {
        this.promocion = promocion;
    }

}
