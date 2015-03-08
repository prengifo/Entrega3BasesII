package main.java.entrega.states;

import main.java.entrega.models.TarjetaDeCredito;

/**
 * TDC vencida, no puede ser usada mas nunca.
 */
public class EstadoVencida implements Estado {
    @Override
    public void doAction(TarjetaDeCredito tdc) {

        System.out.println("Tarjeta no puede ser usada mas en compras");

        tdc.setVencida(true);
    }
}
