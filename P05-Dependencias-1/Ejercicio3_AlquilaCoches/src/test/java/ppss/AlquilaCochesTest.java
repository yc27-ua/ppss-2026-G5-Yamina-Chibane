package ppss;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ServicioStub implements IService {
    public float consultaPrecio(TipoCoche tipo) { return 10; }
}

class CalendarioStub extends Calendario {
    @Override
    public boolean es_festivo(LocalDate d) { return false; }
}

class AlquilaCochesTestable extends AlquilaCoches {
    IService servicio;
    public void setServicio(IService s) { servicio = s; }
    @Override
    protected IService getServicio() { return servicio; }
}

public class AlquilaCochesTest {

    @Test
    void C1_calculaPrecio() {
        AlquilaCochesTestable a = new AlquilaCochesTestable();
        a.setServicio(new ServicioStub());
        a.calendario = new CalendarioStub();

        Ticket t = a.calculaPrecio(TipoCoche.TURISMO, LocalDate.of(2024,5,18), 10);

        assertEquals(100, t.getPrecio_final());
    }
}
