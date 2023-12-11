package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que representa la interfaz de entrada de información del usuario para la reserva de asientos.
 */
public class BusUserInput extends JPanel {
    private BusFrame frame;
    private Bus bus;
    private BusDisplay display;
    private JTextField nombre, apellido, correo, rut, telefono;
    private String[] pagos = {"Elige un Método de Pago", "Tarjeta", "Billetera Electrónica", "Efectivo al abordar"};
    private Cliente cliente;
    private BusData data;
    public Reserva reserva;
    JComboBox<String> pago;

    /**
     * Constructor de la clase BusUserInput.
     *
     * @param bus    Referencia al objeto Bus para el cual se realizarán las operaciones de reserva.
     * @param display Referencia al objeto BusDisplay para mostrar la interfaz gráfica de los asientos.
     * @param frame  Referencia al objeto BusFrame asociado al panel.
     * @param data   Referencia al objeto BusData para manejar la información sobre los asientos y el precio total.
     */
    BusUserInput(Bus bus, BusDisplay display, BusFrame frame, BusData data) {
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
        this.add(createPanel(" Nombre:   ", nombre));
        this.add(createPanel(" Apellidos: ", apellido));
        this.add(createPanel(" Correo:     ", correo));
        this.add(createPanel(" RUT:         ", rut));
        this.add(createPanel(" Telefono: ", telefono));
        this.add(pago);
    }

    /**
     * Obtiene el objeto Cliente con la información ingresada por el usuario.
     *
     * @return Objeto de la clase Cliente con la información del usuario.
     */
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

    /**
     * Crea un panel con un Label para indicar que colocar en el campo y un campo de texto.
     *
     * @param s  Texto para indicar.
     * @param tf Objeto JTextField asociado al campo de texto.
     * @return Panel que contiene la etiqueta y el campo de texto.
     */
    public JPanel createPanel(String s, JTextField tf) {
        JPanel panel = new JPanel();
        JLabel text = new JLabel(s);
        panel.setLayout(new BorderLayout());
        panel.add(text, BorderLayout.WEST);
        panel.add(tf, BorderLayout.CENTER);
        return (panel);
    }

    /**
     * Genera un frame para mostrar las Excepciones al usuario.
     *
     * @param errorMessage Mensaje de error a mostrar.
     */
    private static void ErrorFrame(String errorMessage) {
        JFrame errorFrame = new JFrame("Error");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(errorMessage);

        panel.add(label);
        errorFrame.add(panel);

        errorFrame.setSize(400, 100);
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.setLocationRelativeTo(null);
        errorFrame.setVisible(true);
    }
}
