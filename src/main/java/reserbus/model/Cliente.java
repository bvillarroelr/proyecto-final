package reserbus.model;

public class Cliente {
    private String nombre;
    private String apellido;
    private String rut;
    private Bus b;
    private Reserva r;
    public Cliente(Bus b) {
        this.b = b;
        r = new Reserva(b);
    }
    public boolean dispAsiento(Asiento a) {
        return a.getDisponible();
    }
    public boolean reservarAsiento(Asiento a) { // retorna true si se pudo hacer la reserva, false en caso contrario
        if(a.getDisponible()) {
            r.addAsiento(a);
            a.setDisponible(false);
            return true;
        }
        else {
            return false;   // eventualmente cambiar a un throw exception
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                '}';
    }
}
