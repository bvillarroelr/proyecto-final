package reserbus.model;

import java.util.ArrayList;

public class Reserva {
    private Bus b;
    private ArrayList<Asiento> asientos;    // es un arraylist porque la reserva puede ser de múltiples asientos.
    private float precioTotal;
    public Reserva(Bus b, Asiento a) {
        this.b = b;
        asientos.add(a);
    }
    public float returnPrecioTotal() {
        int n = asientos.size();
        float sum = 0;

        for(int i = 0; i < n; i++) {
            sum += asientos.get(i).getPrecio();
        }

        return sum;
    }
}
