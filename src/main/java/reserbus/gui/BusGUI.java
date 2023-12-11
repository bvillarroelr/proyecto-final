package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase JPanel que contiene mas JPanels con sus secciones y campos para la reserva.
 */
public class BusGUI extends JPanel {
    private JFrame f;
    private BusData dt;
    private BusDisplay dp;
    private BusUserData ud;
    private JPanel BusGuiPanel = new JPanel();
    private JButton reservar;

    /**
     * Constructor de la clase BusGUI.
     *
     * @param f   Referencia al Frame al que pertenece
     * @param bus  Bus asociado a la reserva.
     */
    public BusGUI(BusFrame f, Bus bus) {
        this.f = f;
        this.dt = new BusData(bus);
        this.setLayout(new BorderLayout());
        this.add(BusGuiPanel, BorderLayout.CENTER);
        this.ud = new BusUserData(f, bus, dp, dt);
        dp = new BusDisplay(bus, ud, dt);
        BusGuiPanel.setLayout(new GridLayout(0, 3));
        BusGuiPanel.add(ud);
        BusGuiPanel.add(dp);
        BusGuiPanel.add(dt);

        reservar = new JButton("Reservar");
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = ud.ui.getCliente();
                if (cliente == null) {
                    return;
                }

                List<Asiento> asientosReservados = new ArrayList<>();

                for (int i = 0; i < dp.getSeatButtons().length; i++) {
                    for (int j = 0; j < dp.getSeatButtons()[i].length; j++) {
                        if (j != 2) {
                            JToggleButton button = dp.getSeatButtons()[i][j];
                            if (button.isSelected()) {
                                Asiento asiento = bus.getAsiento(calcSeatPos(i, j));
                                if (asiento.getDisponible()) {
                                    asientosReservados.add(asiento);
                                } else {
                                    ErrorFrame("Error: Uno de los asientos seleccionados no está disponible");
                                    return;
                                }
                            }
                        }
                    }
                }

                if (asientosReservados.isEmpty()) {
                    ErrorFrame("Error: Ningún asiento seleccionado");
                    return;
                }

                // Si llegamos aquí, todos los asientos están disponibles, podemos marcarlos como ocupados
                for (Asiento asiento : asientosReservados) {
                    asiento.setDisponible(false);
                    ud.ui.reserva.addAsiento(asiento);
                }

                f.revalidate();
                f.repaint();
                FeedbackFrame newFrame = new FeedbackFrame(cliente);
                f.dispose();
            }
        });
        this.add(reservar, BorderLayout.SOUTH);
    }

    /**
     * Genera un frame para mostrar las Excepciones al usuario.
     *
     * @param errorMessage Mensaje de error a mostrar.
     */
    private static void ErrorFrame(String errorMessage) {
        JFrame errorFrame = new JFrame("Error");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(errorMessage);

        panel.add(label);
        errorFrame.add(panel);

        errorFrame.setSize(400, 100);
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.setLocationRelativeTo(null);
        errorFrame.setVisible(true);
    }

    /**
     * Calcula la posición del asiento en la lista de asientos.
     *
     * @param i Índice de fila.
     * @param j Índice de columna.
     * @return Posición del asiento en la lista de asientos.
     */
    public int calcSeatPos(int i, int j) {
        if (j < 2) {
            return i * 4 + j + 1;
        } else {
            return i * 4 + j;
        }
    }
}
