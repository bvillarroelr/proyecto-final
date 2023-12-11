package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa el Frame de retroalimentación tras completar una operación y ordena sus componentes.
 */
public class FeedbackFrame extends JFrame {
    private JPanel Feedback = new JPanel();
    private FeedbackResult r;
    private FeedbackPay p;

    /**
     * Constructor de la clase FeedbackFrame.
     *
     * @param c Objeto de la clase Cliente asociado a la operación completada.
     */
    public FeedbackFrame(Cliente c) {
        this.r = new FeedbackResult(this, c);
        this.p = new FeedbackPay(c);
        Feedback.setLayout(new GridLayout(0, 2));
        Feedback.add(r);
        Feedback.add(p);
        this.add(Feedback);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Operación Completada");
        setSize(1080, 720);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
