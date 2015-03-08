package main.java.entrega.models;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by patrickrengifo on 3/8/15.
 */
@Embeddable
public class CompraId implements Serializable {

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
