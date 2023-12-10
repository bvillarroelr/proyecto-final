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
    private JToggleButton cambiar = new JToggleButton("Cambiar de piso");

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

    private void drawDosPisos(BusData data) {
        cambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userData.ui.reserva.clear();
                removeAll();
                currentPiso = (currentPiso + 1) % 2;  // Alternar entre 0 y 1
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

    private void drawPiso(int piso) {
        int inicioAsientos = piso * 20 + 1;  // Calcular el inicio de los asientos según el piso

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int numeroAsiento = inicioAsientos + calcSeatPos(i, j);
                JToggleButton b;

                if (j != 2) {
                    if (bus.getAsiento(numeroAsiento).getTipo() == TipoAsiento.SEMICAMA) {
                        b = SeatButton("/AsientoSemiCama.jpg");
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

    public JToggleButton[][] getSeatButtons() {
        return seatButtons;
    }

    public int calcSeatPos(int i, int j) {
        if (j < 2) {
            return i * 4 + j;
        } else {
            return i * 4 + j - 1;
        }
    }
}
