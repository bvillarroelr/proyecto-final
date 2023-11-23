package reserbus.gui;

import javax.swing.*;
import java.awt.*;

public class BusDisplay extends JPanel {
    public BusDisplay() {
        this.setLayout(new GridLayout(5,5));
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                JLabel w = new JLabel(""+ i + "," + j);
                this.add(w);
            }
        }
    }
}
