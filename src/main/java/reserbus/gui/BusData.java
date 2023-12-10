package reserbus.gui;
import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BusData extends JPanel {
    public ArrayList<Asiento> reservas;
    public JPanel info = new JPanel();
    public BusData() {
        setLayout(new BorderLayout());
        add(info,BorderLayout.NORTH);
    }
    public void addReserva(Asiento a) {
        reservas.add(a);
    }
    public void infoSetup(){
        JPanel rojo = new JPanel();
        JLabel ocupado = new JLabel(": Asiento Ocupado");
        rojo.setBackground(Color.RED);
        rojo.setPreferredSize(new Dimension(10,10));
        info.setLayout(new GridLayout(3,2));
        info.add(rojo);
        info.add(ocupado);
    }
}
