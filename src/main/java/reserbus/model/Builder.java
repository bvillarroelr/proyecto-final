package reserbus.model;

import java.util.Date;

public interface Builder {
    public void setColor(Colors c);
    public void setDosPisos(boolean b);
    public void setCantidadAsientos(int n);
    public void setFecha(Date f);
    public void setInicio(String i);
    public void setDestino(String d);
}
