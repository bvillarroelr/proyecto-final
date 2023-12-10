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
    private JButton reservar = new JButton("Reservar");
    private String[] pagos = {"Elige un Metodo de Pago","Tarjeta", "Billetera Electrónica", "Efectivo al abordar"};
    private Cliente cliente;
    private BusData data;
    public Reserva reserva;

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
        JComboBox<String> pago = new JComboBox<>(pagos);
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    return;
                }
                for (int row = 0; row < 5; row++) {
                    for (int col = 0; col < 5; col++) {
                        if (col != 2) {
                            JToggleButton button = display.getSeatButtons()[row][col];
                            if (button.isSelected()) {
                                System.out.println("Seat selected at position: " + row + ", " + col);
                                if (bus.getAsiento(4 * row + col).getDisponible() == true) {
                                    reserva.addAsiento(bus.getAsiento(3 * row + col));
                                    bus.getAsiento(4 * row + col).setDisponible(false);
                                } else {
                                    ErrorFrame("Error: Uno de los asientos seleccionados no esta disponible");
                                    break;
                                }
                            }
                        }
                    }
                }
                frame.revalidate();
                frame.repaint();
                FeedbackFrame newFrame = new FeedbackFrame(cliente);
                frame.dispose();
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
    /*public ArrayList<Asiento> getReservas(){
        return reservas;
        */
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
