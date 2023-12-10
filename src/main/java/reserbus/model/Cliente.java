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
    // nos serviran para registrar los datos del cliente al reservar
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Reserva getReserva() {
        return r;
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
