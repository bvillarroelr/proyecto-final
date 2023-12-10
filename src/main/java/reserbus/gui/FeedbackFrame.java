package reserbus.gui;

import reserbus.model.*;
import javax.swing.*;
import java.awt.*;

public class FeedbackFrame extends JFrame {
    private JPanel Feedback = new JPanel();
    private FeedbackResult r = new FeedbackResult(this);
    private FeedbackPay p;
    public FeedbackFrame(Cliente c) {
        this.p = new FeedbackPay(c);
        Feedback.setLayout(new GridLayout(0,2));
        Feedback.add(p);
        Feedback.add(r);
        this.add(Feedback);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Operacion Completada!");
        setSize(1080, 720);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
