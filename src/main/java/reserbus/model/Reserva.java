package reserbus.model;

import java.util.ArrayList;

public class Reserva {
    private Bus b;
    private ArrayList<Asiento> asientos;    // es un arraylist porque la reserva puede ser de múltiples asientos.
    private float precioTotal;
    public Reserva(Bus b) {
        this.b = b;
    }
    public void addAsiento(Asiento a) {
        asientos.add(a);
    }
    public float calculaPrecioTotal() {
        int n = asientos.size();
        precioTotal = 0;

        for(int i = 0; i < n; i++) {
            precioTotal += asientos.get(i).getPrecio();
        }
        return precioTotal;
    }
}
