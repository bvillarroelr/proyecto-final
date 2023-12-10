package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;

// Esta clase mostrara la informacion de un bus en terminos de reservas
public class BusGUI extends JPanel {
    private JFrame f;
    private BusData dt = new BusData();
    private BusDisplay dp;
    private BusUserData ud;
    public BusGUI(BusFrame f,Bus bus){
        this.f = f;
        dp = new BusDisplay(bus);
        this.ud = new BusUserData(f,bus,dp);
        this.setLayout(new GridLayout(0,3));
        this.add(ud);
        this.add(dp);
        this.add(dt);
    }

}
