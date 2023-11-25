package reserbus.model;

public class Cliente {
    private Bus b;
    private Reserva r;
    public Cliente(Bus b) {
        this.b = b;
    }
    public boolean dispAsiento(Asiento a) {
        return a.getDisponible();
    }
    public boolean reservarAsiento(Asiento a) { // retorna true si se pudo hacer la reserva, false en caso contrario
        if(a.getDisponible()) {
            r = new Reserva(b,a);
            a.setDisponible(false);
            return true;
        }
        else {
            return false;
        }
    }
}
