package reserbus.model;

import java.util.ArrayList;

public class Bus {
    private ArrayList<Asiento> asientos;
    private int cantidadAsientos;
    public Bus(int cantidadAsientos) {
        asientos = new ArrayList<Asiento>();
        for(int i = 0; i<cantidadAsientos; i++) {
            asientos.add(new Asiento(i));
        }
    }
    public Asiento getAsiento(int id) {
        return asientos.get(id);
    }
    public int getCantidadAsientos() {
        return this.cantidadAsientos;
    }

}
