package reserbus.model;


import java.util.Date;

public class BusBuilder implements Builder {
    private int cantidadAsientos;
    private Colors color;
    private boolean dosPisos;
    private String inicio;
    private String destino;
    private Date fecha;
    @Override
    public void setColor(Colors color) {
        this.color = color;
    }

    @Override
    public void setDosPisos(boolean b) {
        this.dosPisos = b;
    }

    @Override
    public void setCantidadAsientos(int n) {
        this.cantidadAsientos = n;
    }

    @Override
    public void setFecha(Date f) {
        this.fecha = f;
    }

    @Override
    public void setInicio(String i) {
        this.inicio = i;
    }

    @Override
    public void setDestino(String d) {
        this.destino = d;
    }

    public Bus getResult() {
        return new Bus(cantidadAsientos, color, dosPisos, inicio, destino); // falta fecha
    }

}