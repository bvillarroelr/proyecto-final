package reserbus.model;

public class Reserva {
    private Bus b;
    private Asiento a;
    private float precioTotal;
    public Reserva(Bus b, Asiento a) {
        this.b = b;
        this.a = a;
    }
}
