package reserbus.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {
    @Test
    public void precioTotalDeberiaSer12000() {
        // construimos el bus
        BusBuilder busSimple = new BusBuilder();
        Director d = new Director();
        d.constructBusSimpleDia(busSimple, "Conce", "Santiago", new Date(2024,2,2));
        Bus b = busSimple.getResult();
        // asociamos el cliente al bus
        Cliente c = new Cliente(b);
        c.reservarAsiento(b.getAsiento(1));
        c.reservarAsiento(b.getAsiento(2));
        float precioTotal = c.getReserva().calculaPrecioTotal();
        // verificamos que el valor calculado es el esperado
        assertEquals(12000, precioTotal);
    }
    @Test
    public void intentarReservarAsientoOcupadoNoDeberiaCobrarse() {
        // construimos el bus
        BusBuilder busSimple = new BusBuilder();
        Director d = new Director();
        d.constructBusSimpleDia(busSimple, "Conce", "Santiago", new Date(2024,2,2));
        Bus b = busSimple.getResult();
        // asociamos el cliente al bus
        Cliente c = new Cliente(b);
        c.reservarAsiento(b.getAsiento(1)); // $6000
        c.reservarAsiento(b.getAsiento(2)); // $12000
        c.reservarAsiento(b.getAsiento(1)); // asiento ocupado, precio final $12000
        float precioTotal = c.getReserva().calculaPrecioTotal();
        assertEquals(12000, precioTotal);
    }
}