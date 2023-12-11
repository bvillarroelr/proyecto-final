package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;

public class FeedbackPay extends JPanel {
    private JLabel pagoFeed = new JLabel();
    private JLabel boleta = new JLabel();
    private JPanel reservasPanel = new JPanel(); // Panel para las reservas

    FeedbackPay(Cliente c) {
        setLayout(new GridLayout(3, 0));
        if (c.getPago().equals("Efectivo al abordar")) {
            pagoFeed.setText("Reserva hecha, Recuerda llevar efectivo el día del viaje!");
        } else {
            pagoFeed.setText("Pago realizado con Éxito!");
        }

        boleta.setText("<html>Nombre: " + c.getNombre() + " " + c.getApellido() + "<br>RUT:" + c.getRut() + "<br>Asientos Reservados:</html>");

        for (int i=0;i<c.getReserva().getAsientosLength();i++) {
            JLabel asientoLabel = new JLabel("Asiento-" + c.getReserva().getAsientos().get(i).getID());
            reservasPanel.add(asientoLabel);
            reservasPanel.setVisible(true);
        }

        reservasPanel.setLayout(new GridLayout(20,0));

        add(pagoFeed);
        add(boleta);
        add(reservasPanel);
    }
}
