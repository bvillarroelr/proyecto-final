package reserbus.model;

import java.util.Date;

public class Director {
    public void constructBusSimple(Builder builder, String inicio, String destino, Date fecha) {
        builder.setColor(Colors.BLUE);  // buses simples seran azules
        builder.setDosPisos(false);
        builder.setCantidadAsientos(22);
        builder.setFecha(fecha);
        builder.setInicio(inicio);
        builder.setDestino(destino);
    }

    public void constructBus2Pisos(Builder builder, String inicio, String destino, Date fecha) {
        builder.setColor(Colors.RED);   // buses dos pisos seran rojos
        builder.setDosPisos(true);
        builder.setCantidadAsientos(22); // 22 * 2 (por los dos pisos)
        builder.setFecha(fecha);
        builder.setInicio(inicio);
        builder.setDestino(destino);
    }
}
