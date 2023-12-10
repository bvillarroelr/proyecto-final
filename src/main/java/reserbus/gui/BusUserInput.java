package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusUserInput extends JPanel {
    private Bus bus;
    private BusDisplay display;
    private JTextField nombre, apellido, correo, rut, telefono;
    private JButton reservar = new JButton("Reservar");
    private String[] pagos = {"Elige un Metodo de Pago","Tarjeta", "Billetera Electrónica", "Efectivo al abordar"};

    BusUserInput(Bus bus,BusDisplay display) {
        this.bus = bus;
        this.display = display;
        setLayout(new GridLayout(7, 2, 100, 50));
        nombre = new JTextField();
        apellido = new JTextField();
        correo = new JTextField();
        rut = new JTextField();
        telefono = new JTextField();
        JComboBox<String> pago = new JComboBox<>(pagos);
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int row = 0; row < display.getSeatButtons().length; row++) {
                    for (int col = 0; col < display.getSeatButtons()[row].length; col++) {
                        if(col !=2){
                            JToggleButton button = display.getSeatButtons()[row][col];
                            if (button.isSelected()) {
                                System.out.println("Seat selected at position: " + row + ", " + col);
                                bus.getAsiento(4*row+col).setDisponible(false);
                                //Aca puede seguir codigo para cambiar cosas seleccionadas
                            }
                        }
                    }
                }
                String nombreText = nombre.getText();
                String apellidoText = apellido.getText();
                String correoText = correo.getText();
                String rutText = rut.getText();
                String telefonoText = telefono.getText();
                String pagoSeleccionado = (String) pago.getSelectedItem();

                System.out.println("Reservando:");
                System.out.println("Nombre: " + nombreText);
                System.out.println("Apellido: " + apellidoText);
                System.out.println("Correo: " + correoText);
                System.out.println("RUT: " + rutText);
                System.out.println("Teléfono: " + telefonoText);
                System.out.println("Método de pago: " + pagoSeleccionado);
            }
        });
        this.add(createPanel(" Nombre:   ",nombre));
        this.add(createPanel(" Apellidos: ",apellido));
        this.add(createPanel(" Correo:     ",correo));
        this.add(createPanel(" RUT:         ",rut));
        this.add(createPanel(" Telefono: ",telefono));
        this.add(pago);

        this.add(reservar, BorderLayout.SOUTH);
    }
    public JPanel createPanel(String s,JTextField tf){
        JPanel panel = new JPanel();
        JLabel text = new JLabel(s);
        panel.setLayout(new BorderLayout());
        panel.add(text,BorderLayout.WEST);
        panel.add(tf, BorderLayout.CENTER);
        return(panel);
    }
}
