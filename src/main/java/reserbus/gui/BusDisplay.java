package reserbus.gui;

import reserbus.model.Bus;
import reserbus.model.TipoAsiento;

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
    public BusDisplay(Bus bus,BusUserData userdata,BusData data) {
        this.bus = bus;
        this.userData = userdata;
        this.data = data;
        seatButtons = new JToggleButton[5][5];
        this.setLayout(new GridLayout(5, 5, 25, 50));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                final int numeroAsiento = calcSeatPos(i,j);
                JToggleButton b;

                if (j != 2) {
                    if (bus.getAsiento(calcSeatPos(i,j)).getTipo() == TipoAsiento.SEMICAMA) {
                        b = SeatButton("/AsientoSemiCama.jpg");
                    } else {
                        b = SeatButton("/AsientoNormal.jpg");
                    }
                    if (bus.getAsiento(calcSeatPos(i,j)).getDisponible()) {
                        b.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                    } else {
                        b.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                    }
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (b.isSelected()) {
                                b.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
                                userdata.ui.reserva.addAsiento(bus.getAsiento(numeroAsiento));
                                data.updateAsientos(userdata.ui.reserva.getAsientos());
                            } else {
                                b.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                                userdata.ui.reserva.removeAsiento(bus.getAsiento(numeroAsiento));
                                data.updateAsientos(userdata.ui.reserva.getAsientos());
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
    public int calcSeatPos(int i,int j) {
        if(j<2) {
            return i*4+j+1;
        }
        else {
            return i*4+j;
        }
    }
}
