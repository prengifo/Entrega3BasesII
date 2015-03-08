package main.java.entrega.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by patrickrengifo on 3/8/15.
 */

@Embeddable
public class CiudadId implements Serializable {
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
