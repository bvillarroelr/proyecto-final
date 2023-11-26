package reserbus.gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class BusDisplay extends JPanel {
    public BusDisplay() {
        this.setLayout(new GridLayout(5,5,25,50));
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j!=2) {
                    JButton b = SeatButton("/AsientoNormal.jpg");
                    this.add(b);
                }
                else{
                    this.add(new JLabel());
                }
            }
        }
    }
    private JButton SeatButton(String imagePath) {
        JButton boton = new JButton();
        boton.setContentAreaFilled(false);
        URL imageURL = getClass().getResource(imagePath);
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            boton.setIcon(icon);
        }
        return boton;
    }
}
