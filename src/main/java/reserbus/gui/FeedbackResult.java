package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackResult extends JPanel {
    private FeedbackFrame f;
    private JLabel result,dates,businfo;
    public FeedbackResult(FeedbackFrame f,Cliente c) {
        this.f = f;
        result = new JLabel("<html>Buen Viaje"+ c.getNombre() + "! Hemos enviado tu boleto a tu correo,<br>asegurate de imprimirlo o llevarlo en tu celular al abordar<br>Gracias por viajar con nosotros!</html>");
        dates = new JLabel("Viajas el" );
        setLayout(new BorderLayout());
        JButton nuevaReserva = new JButton("Nueva Reserva");
        nuevaReserva.setPreferredSize(new Dimension(50,100));
        nuevaReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana v = new Ventana();
                f.dispose();
            }
        });
        result.setFont(new Font("Arial", Font.BOLD, 15));
        add(result, BorderLayout.CENTER);
        add(nuevaReserva,BorderLayout.SOUTH);
    }
}
