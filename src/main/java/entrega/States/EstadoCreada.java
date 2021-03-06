package main.java.entrega.states;

import main.java.entrega.helpers.CreditCardValidator;
import main.java.entrega.models.TarjetaDeCredito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TDC recien creada
 */
public class EstadoCreada implements Estado {

    @Override
    public void doAction(TarjetaDeCredito tdc) {

        System.out.println("TDC creada, se verificaran los datos");

        // Validor de numeros de tarjeta
        CreditCardValidator validator = new CreditCardValidator();
        boolean valid = false;

        if (validator.isCreditCardValid(tdc.getNumeroTarjeta(), 0)
                || validator.isCreditCardValid(tdc.getNumeroTarjeta(), 1)
                || validator.isCreditCardValid(tdc.getNumeroTarjeta(), 2)
                || validator.isCreditCardValid(tdc.getNumeroTarjeta(), 3)
                || validator.isCreditCardValid(tdc.getNumeroTarjeta(), 4)){
            valid = true;
        }

        // Si son validos, verificamos la fecha de vencimiento
        if (valid) {
            SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy");
            Date date = null;

            try {

                date = formatter.parse(tdc.getFechaDeVencimiento());
                System.out.println(formatter.format(date));

            } catch (ParseException e) {
                e.printStackTrace();
            }

            assert date != null;
            if (date.before(new Date())) {
                System.out.println("TDC invalida");
                tdc.setEstado(new EstadoInvalida());
                tdc.doAction();
            } else {
                tdc.setEstado(new EstadoActivada());
                tdc.doAction();
            }
        } else {
            System.out.println("TDC invalida");
            tdc.setEstado(new EstadoInvalida());
            tdc.doAction();
        }

    }
}
