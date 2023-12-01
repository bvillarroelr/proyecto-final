package reserbus.model;

import java.util.Date;

public class Director {
    public void constructBusSimple(Builder builder, String inicio, String destino) {
        builder.setColor(Colors.BLUE);
        builder.setDosPisos(false);
        builder.setCantidadAsientos(22);
        builder.setFecha(new Date(2023,12,8));
        builder.setInicio(inicio);
        builder.setDestino(destino);
    }

    public void constructBus2Pisos(Builder builder, String inicio, String destino) {
        builder.setColor(Colors.RED);
        builder.setDosPisos(true);
        builder.setCantidadAsientos(22); // 22 * 2 (por los dos pisos)
        builder.setFecha(new Date(2023,12,9));
        builder.setInicio(inicio);
        builder.setDestino(destino);
    }
}
