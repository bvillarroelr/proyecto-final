package reserbus.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackResult extends JPanel {
    private FeedbackFrame f;
    private JLabel result = new JLabel("Buen Viaje! Hemos enviado tu boleto a tu correo, asegurate de imprimirlo o llevarlo en tu celular al abordar");
    public FeedbackResult(FeedbackFrame f) {
        this.f = f;
        setLayout(new BorderLayout());

        JButton nuevaReserva = new JButton("Nueva Reserva");
        nuevaReserva.setPreferredSize(new Dimension(100,200));
        nuevaReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana v = new Ventana();
                f.dispose();

            }
        });
        add(result, BorderLayout.NORTH);
        add(nuevaReserva, BorderLayout.SOUTH);
    }
}
