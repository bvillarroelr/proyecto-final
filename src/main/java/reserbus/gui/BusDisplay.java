package reserbus.gui;

import reserbus.model.*;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusDisplay extends JPanel {
    private JToggleButton[][] seatButtons;
    private BusUserData userData;
    private BusData data;
    private Bus bus;
    private int currentPiso;
    private JToggleButton cambiar = new JToggleButton("2");

    /**
     * Constructor de la clase BusDisplay.
     *
     * @param bus     Bus asociado al display.
     * @param userdata Referencia a BusUserData para manejar los datos del usuario.
     * @param data    Referencia a BusData para sincronizar con las selecciones.
     */
    public BusDisplay(Bus bus, BusUserData userdata, BusData data) {
        this.bus = bus;
        this.userData = userdata;
        this.data = data;
        seatButtons = new JToggleButton[5][5];
        this.setLayout(new GridLayout(6, 5, 25, 50));
        currentPiso = 0;

        if (bus.isDosPisos()) {
            drawDosPisos(data);
            drawPiso(currentPiso);
            add(new JLabel());
            add(new JLabel());
            add(cambiar);
            add(new JLabel());
            add(new JLabel());
        } else {
            drawPiso(currentPiso);
        }
    }

    /**
     * Dibuja la interfaz gráfica para un caso bus de dos pisos y añade la funcionalidad para cambiar entre pisos.
     *
     * @param data Referencia a objeto BusData para manejar la información sobre los asientos y el precio total.
     */
    private void drawDosPisos(BusData data) {
        cambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userData.ui.reserva.clear();
                removeAll();
                currentPiso = (currentPiso + 1) % 2;
                drawPiso(currentPiso);
                add(new JLabel());
                add(new JLabel());
                add(cambiar);
                add(new JLabel());
                add(new JLabel());

                revalidate();
                repaint();
            }
        });
        add(cambiar);
    }

    /**
     * Dibuja la interfaz gráfica para un piso del bus, mostrando los asientos y permitiendo la selección.
     *
     * @param piso Número del piso a dibujar (0 o 1 para un bus de dos pisos, 0 para un bus de un piso).
     */
    private void drawPiso(int piso) {
        int inicioAsientos = piso * 20 + 1;  // Calcular el inicio de los asientos según el piso

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int numeroAsiento = inicioAsientos + calcSeatPos(i, j);
                JToggleButton b;

                if (j != 2) {
                    if (bus.getAsiento(numeroAsiento).getTipo() == TipoAsiento.SEMICAMA) {
                        b = SeatButton("/AsientoSemiCama.jpg");
                    } else if (bus.getAsiento(numeroAsiento).getTipo() == TipoAsiento.CAMA) {
                        b = SeatButton("/AsientoCama.jpg");
                    } else {
                        b = SeatButton("/AsientoNormal.jpg");
                    }
                    if (bus.getAsiento(numeroAsiento).getDisponible()) {
                        b.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                    } else {
                        b.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    }
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (b.isSelected()) {
                                b.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
                                userData.ui.reserva.addAsiento(bus.getAsiento(numeroAsiento));
                                bus.getAsiento(numeroAsiento).setID(numeroAsiento);
                                data.updateAsientos(userData.ui.reserva.getAsientos());
                            } else {
                                b.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                                userData.ui.reserva.removeAsiento(bus.getAsiento(numeroAsiento));
                                data.updateAsientos(userData.ui.reserva.getAsientos());
                            }
                        }
                    });
                    seatButtons[i][j] = b;
                    this.add(b);
                } else {
                    this.add(new JLabel());
                }
            }
        }
        revalidate();
        repaint();
    }

    /**
     * Crea un botón de asiento
     *
     * @param imagePath Ruta de la imagen del asiento.
     * @return JToggleButton configurado
     */
    private JToggleButton SeatButton(String imagePath) {
        JToggleButton boton = new JToggleButton();
        boton.setContentAreaFilled(false);
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            boton.setIcon(icon);
        }
        return boton;
    }

    /**
     * Getter de la matriz de botones de asientos.
     *
     * @return Matriz de JToggleButton que representa los botones de asientos.
     */
    public JToggleButton[][] getSeatButtons() {
        return seatButtons;
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
            return i * 4 + j;
        } else {
            return i * 4 + j - 1;
        }
    }
}
