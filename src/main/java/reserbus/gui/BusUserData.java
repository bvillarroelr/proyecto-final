package reserbus.gui;
import javax.swing.*;
import java.awt.*;

public class BusUserData extends JPanel{
    JButton reservar = new JButton("Reservar");
    JButton volver = new JButton("Volver");
    public BusUserData(){
        this.setLayout(new BorderLayout());
        this.add(reservar,BorderLayout.SOUTH);
        this.add(volver,BorderLayout.NORTH);
    }
}
