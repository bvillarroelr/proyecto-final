package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class BusUserInput extends JPanel {
    private BusFrame frame;
    private Bus bus;
    private BusDisplay display;
    private JTextField nombre, apellido, correo, rut, telefono;
    private String[] pagos = {"Elige un Metodo de Pago","Tarjeta", "Billetera Electrónica", "Efectivo al abordar"};
    private Cliente cliente;
    private BusData data;
    public Reserva reserva;
    JComboBox<String> pago;

    BusUserInput(Bus bus,BusDisplay display,BusFrame frame,BusData data) {
        this.bus = bus;
        this.display = display;
        this.cliente = new Cliente(bus);
        this.frame = frame;
        this.data = data;
        this.reserva = new Reserva(bus);
        setLayout(new GridLayout(7, 2, 100, 80));
        nombre = new JTextField();
        apellido = new JTextField();
        correo = new JTextField();
        rut = new JTextField();
        telefono = new JTextField();
        this.pago = new JComboBox<>(pagos);
        this.add(createPanel(" Nombre:   ",nombre));
        this.add(createPanel(" Apellidos: ",apellido));
        this.add(createPanel(" Correo:     ",correo));
        this.add(createPanel(" RUT:         ",rut));
        this.add(createPanel(" Telefono: ",telefono));
        this.add(pago);
    }
    public Cliente getCliente() {
        String nombreText = nombre.getText();
        String apellidoText = apellido.getText();
        String correoText = correo.getText();
        String rutText = rut.getText();
        String telefonoText = telefono.getText();
        String pagoSeleccionado = (String) pago.getSelectedItem();
        try {
            cliente.setCliente(nombreText, apellidoText, correoText, rutText, telefonoText, pagoSeleccionado);
        } catch (IllegalArgumentException exc) {
            ErrorFrame(exc.getMessage());
            return null;
        }
        return cliente;
    }
    public JPanel createPanel(String s,JTextField tf){
        JPanel panel = new JPanel();
        JLabel text = new JLabel(s);
        panel.setLayout(new BorderLayout());
        panel.add(text,BorderLayout.WEST);
        panel.add(tf, BorderLayout.CENTER);
        return(panel);
    }
    private static void ErrorFrame(String mensajeError) {
        JFrame errorFrame = new JFrame("Error");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(mensajeError);

        panel.add(label);
        errorFrame.add(panel);

        errorFrame.setSize(400, 100);
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.setLocationRelativeTo(null);
        errorFrame.setVisible(true);
    }
}
