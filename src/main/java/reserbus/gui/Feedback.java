package reserbus.gui;

import javax.swing.*;
import java.awt.*;

public class Feedback extends JPanel {
    FeedbackResult r = new FeedbackResult();
    FeedbackPay p = new FeedbackPay();
    public Feedback() {
        this.setLayout(new GridLayout(0,2));
        this.add(r);
        this.add(p);
    }
}
