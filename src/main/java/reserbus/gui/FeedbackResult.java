package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
/**
 * Clase que representa la sección de resultados y detalles de la reserva en la pantalla de feedback.
 */
public class FeedbackResult extends JPanel {
    private FeedbackFrame f;
    private JLabel result, boleta, pagoFeed;
    private JPanel end = new JPanel();
    /**
     * Constructor de la clase FeedbackResult.
     *
     * @param f Referencia al objeto de la clase FeedbackFrame.
     * @param c Cliente.
     */

    public FeedbackResult(FeedbackFrame f, Cliente c) {
        this.f = f;
        c.setCodigo(generarCodigo());
        result = new JLabel("<html>Buen Viaje " + c.getNombre() + "! Hemos enviado tu boleto a tu correo,<br>asegurate de imprimirlo o llevarlo en tu celular al abordar<br>Gracias por viajar con nosotros!</html>");
        result.setBackground(new Color(147, 236, 134));
        result.setFont(new Font("Arial", Font.BOLD, 24));

        boleta = new JLabel("<html>Nombre: " + c.getNombre() + " " + c.getApellido() + "<br>Codigo de Reserva: " + c.getCodigo() + "<br>RUT: " + c.getRut() + "<br>Fecha: " + c.getB().getFecha() + "</html>");
        boleta.setFont(new Font("Arial", Font.PLAIN, 15));

        if (c.getPago().equals("Efectivo al abordar")) {
            pagoFeed = new JLabel("Reserva hecha, Recuerda llevar efectivo el día del viaje!");
        } else {
            pagoFeed = new JLabel("Pago realizado con Éxito!");
        }
        pagoFeed.setFont(new Font("Arial", Font.PLAIN, 15));

        end.setLayout(new BorderLayout());
        end.add(boleta, BorderLayout.CENTER);
        end.add(pagoFeed, BorderLayout.NORTH);

        setLayout(new BorderLayout());
        setBackground(new Color(147, 236, 134));

        JButton nuevaReserva = new JButton("Nueva Reserva");
        nuevaReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventana v = new Ventana();
                f.dispose();
            }
        });

        add(result, BorderLayout.NORTH);
        add(nuevaReserva, BorderLayout.SOUTH);
        add(end, BorderLayout.CENTER);
    }
    /**
     * Genera un código aleatorio de longitud 10.
     *
     * @return Código generado.
     */
    public String generarCodigo() {
        Random random = new Random();
        int longitudCodigo = 10;
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < longitudCodigo; i++) {
            int digito = random.nextInt(10);
            codigo.append(digito);
        }
        return codigo.toString();
    }
}
