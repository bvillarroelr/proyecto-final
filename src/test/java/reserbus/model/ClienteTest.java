package reserbus.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    public void reservaAsientoVacioTest() {
        // Test de los métodos reservarAsiento() y dispAsiento()
        BusBuilder busSimple = new BusBuilder();
        Director d = new Director();
        d.constructBusSimpleDia(busSimple, "Conce", "Santiago", new Date(2024,2,2));
        Bus b = busSimple.getResult();
        Cliente c = new Cliente(b);
        assertTrue(c.dispAsiento(b.getAsiento(0))); // Verifica el estado de un asiento vacío
        assertTrue(c.reservarAsiento(b.getAsiento(0))); // Verifica si se reserva el asiento con exito
        assertFalse(c.dispAsiento(b.getAsiento(0)));    // Verifica el estado del asiento ya reservado
    }
    @Test
    public void reservaAsientoOcupadoTest() {
        BusBuilder busSimple = new BusBuilder();
        Director d = new Director();
        d.constructBusSimpleDia(busSimple, "Conce", "Santiago", new Date(2024,2,2));
        Bus b = busSimple.getResult();

        Cliente c = new Cliente(b);
        Cliente c1 = new Cliente(b);
        c1.reservarAsiento(b.getAsiento(0));    // Cliente c1 reserva el asiento 0
        assertFalse(c.dispAsiento(b.getAsiento(0)));    // Cliente c revisa el estado del siento 0
        assertFalse(c.reservarAsiento(b.getAsiento(0))); // Cliente c intenta reservar el asiento 0
    }
}