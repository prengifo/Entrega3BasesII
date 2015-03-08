package main.java.entrega.states;

import main.java.entrega.models.TarjetaDeCredito;

/**
 * Estado:
 * Define interfaz para encapsular comportamiento asociado con un estado de TDC.
 */
public interface Estado {
    public void doAction(TarjetaDeCredito tdc);
}
