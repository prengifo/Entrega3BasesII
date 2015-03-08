package main.java.entrega.states;

import main.java.entrega.models.TarjetaDeCredito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TDC lista para ser usada por el usuario
 */
public class EstadoActivada implements Estado {
    @Override
    public void doAction(TarjetaDeCredito tdc) {

        System.out.println("Tarjeta lista para ser usada en cualquier momento");

        System.out.println("Verificamos no se haya vencido");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;

        try {

            date = formatter.parse(tdc.getFechaDeVencimiento());
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert date != null;
        if (date.after(new Date())) {
            tdc.setEstado(new EstadoInvalida());
        }
    }
}
