package reserbus.gui;

import reserbus.model.Bus;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusDisplay extends JPanel {
    private JToggleButton[][] seatButtons;
    public BusDisplay() {
        seatButtons = new JToggleButton[5][5];
        this.setLayout(new GridLayout(5, 5, 25, 50));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j != 2) {
                    JToggleButton b = SeatButton("/AsientoNormal.jpg");
                    b.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (b.isSelected()) {
                                b.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                            } else {
                                b.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
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
}
