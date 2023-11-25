package reserbus.gui;

import javax.swing.*;
import java.awt.*;

public class BusDisplay extends JPanel {
    public BusDisplay() {
        this.setLayout(new GridLayout(5,5,25,50));
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j!=2) {
                    BusButton w = new BusButton(j+i/10);
                    this.add(w);
                }
                else{
                    this.add(new JLabel());
                }
            }
        }
    }
}
