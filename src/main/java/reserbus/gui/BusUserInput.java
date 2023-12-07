package reserbus.gui;

import javax.swing.*;
import java.awt.*;

public class BusUserInput extends JPanel {
    private JTextField nombre,apellido,correo,rut,telefono;
    JButton reservar = new JButton("Reservar");
    private String[] pagos = {"Tarjeta","Billetera Electronica","Efectivo al abordar"};
    BusUserInput() {
        setLayout(new GridLayout(7,1,100,50));
        nombre = new JTextField();
        apellido = new JTextField();
        correo = new JTextField();
        rut = new JTextField();
        telefono = new JTextField();
        JComboBox<String> pago = new JComboBox<>(pagos);
        this.add(nombre);
        this.add(apellido);
        this.add(correo);
        this.add(rut);
        this.add(telefono);
        this.add(pago);
        this.add(reservar, BorderLayout.SOUTH);
    }
}
