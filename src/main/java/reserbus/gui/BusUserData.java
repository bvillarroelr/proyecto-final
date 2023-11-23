package reserbus.gui;
import javax.swing.*;
import java.awt.*;

public class BusUserData extends JPanel{
    JButton reservar = new JButton("Reservar");
    public BusUserData(){
        this.setLayout(new BorderLayout());
        this.add(reservar,BorderLayout.SOUTH);
    }
}
