package reserbus.gui;

import javax.swing.*;
import java.awt.*;

// Esta clase mostrara la informacion de un bus en terminos de reservas
public class BusGUI extends JPanel {
    private JFrame f;
    private BusData dt = new BusData();
    private BusDisplay dp = new BusDisplay();
    private BusUserData ud;
    public BusGUI(FrameAsientosBus f){
        this.f = f;
        this.ud = new BusUserData(f);
        this.setLayout(new GridLayout(0,3));
        this.add(ud);
        this.add(dp);
        this.add(dt);
    }

}
