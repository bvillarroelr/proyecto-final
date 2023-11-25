package reserbus.gui;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
// Boton para acceder a la info del bus, quiza lo elimine
public class BusButton extends JButton {
    public BusButton(int n){
        setContentAreaFilled(false); // Hace que el fondo no sea pintado, para poder ver la imagen

            URL imageURL = getClass().getResource("/AsientoNormal.jpg");
            if (imageURL != null) {
                ImageIcon icon = new ImageIcon(imageURL);
                setIcon(icon);
            } else {
                System.err.println("No se pudo cargar la imagen.");
            }
    }
}
