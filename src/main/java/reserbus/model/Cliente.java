package reserbus.model;

public class Cliente {
    private String nombre;
    private String apellido;
    private String correo;
    private String rut;
    private String telefono;
    private String pago;
    private Bus b;
    private Reserva r;
    public Cliente(Bus b) {
        this.b = b;
        r = new Reserva(b);
    }

    /**
     * Permite verificar la disponibilidad del asiento entregado como parámetro. Retorna true o false.
     * @param a Asiento
     * @return
     */
    public boolean dispAsiento(Asiento a) {
        return a.getDisponible();
    }

    /**
     * Reserva un asiento si se encuentra disponible, en caso de estar disponible agrega el asiento a la lista de reservas del cliente, setea el asiento como no disponible y retorna true. De lo contrario retorna false.
     * @param a
     * @return
     */
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
    public void setCliente(String n, String a, String c, String r, String t, String p) throws IllegalArgumentException {
        if (n == null || a == null || c == null || r == null || t == null || p == null) {
            throw new IllegalArgumentException("Error: Campo/os vacios.");
        }
        if (n.contains(" ")) {
            throw new IllegalArgumentException("Error: El nombre no es valido.");
        }
        if (a.contains(" ")) {
            throw new IllegalArgumentException("Error: El apellido no es valido.");
        }
        if (!c.contains("@")) {
            throw new IllegalArgumentException("Error: El correo no es valido.");
        }
        if (r.length() != 10 || r.charAt(8) != '-') {
            throw new IllegalArgumentException("Error: El rut debe tener guion y tener un largo de 10.");
        }
        if (t.length() != 8) {
            throw new IllegalArgumentException("Error: El telefono debe tener 8 caracteres (Sin +56 o 9)");
        }
        if (p.equals("Elige un Metodo de Pago")) {
            throw new IllegalArgumentException("Error: Debes elegir un método de pago válido.");
        }
        this.nombre = n;
        this.apellido = a;
        this.correo = c;
        this.rut = r;
        this.telefono = t;
        this.pago = p;
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
