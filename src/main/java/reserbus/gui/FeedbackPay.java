package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;

public class FeedbackPay extends JPanel {
    private JLabel pagoFeed = new JLabel();
    private JLabel boleta = new JLabel();
    private JLabel reservas = new JLabel();

    FeedbackPay(Cliente c) {
        setLayout(new GridLayout(3, 0));
        if (c.getPago().equals("Efectivo al abordar")) {
            pagoFeed.setText("Reserva hecha, Recuerda llevar efectivo el día del viaje!");
        } else {
            pagoFeed.setText("Pago realizado con Éxito!");
        }

        boleta.setText("<html>Nombre: " + c.getNombre() + " " + c.getApellido() + "<br>RUT:" + c.getRut() + "<br>Asientos Reservados:<html>");
        String reString = "</html>";
        for (int i = 0; i < c.getReserva().getAsientos().size(); i++) {
            reString += "<br> Asiento-" + c.getReserva().getAsientos().get(i).getID();
        }
        reString += "</html>";
        reservas.setText(reString);
        System.out.println(reString);
        add(pagoFeed);
        add(boleta);
        add(reservas);
    }
}