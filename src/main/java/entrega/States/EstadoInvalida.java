package main.java.entrega.states;

import main.java.entrega.models.TarjetaDeCredito;

import static main.java.entrega.Main.deleteTDC;

/**
 * TDC invalidada por datos erroneos
 */
public class EstadoInvalida implements Estado {
    @Override
    public void doAction(TarjetaDeCredito tdc) {

        System.out.println("Liberamos datos de tarjeta invalida");

        deleteTDC(tdc.getNumeroTarjeta());
    }
}
