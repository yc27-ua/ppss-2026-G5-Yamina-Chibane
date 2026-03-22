package ppss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalendarioStub extends Calendario {
    int hora;
    public void setHora(int h) { hora = h; }
    @Override
    public int getHoraActual() { return hora; }
}

class GestorLlamadasTestable extends GestorLlamadas {
    Calendario calendario;
    public void setCalendario(Calendario c) { calendario = c; }
    @Override
    protected Calendario getCalendario() { return calendario; }
}

public class GestorLlamadasTest {

    @Test
    void C1_calculaConsumo_hora_tarde() {
        CalendarioStub stub = new CalendarioStub();
        stub.setHora(15);

        GestorLlamadasTestable g = new GestorLlamadasTestable();
        g.setCalendario(stub);

        double res = g.calculaConsumo(10);
        assertEquals(15.0, res);
    }

    @Test
    void C2_calculaConsumo_hora_madrugada() {
        CalendarioStub stub = new CalendarioStub();
        stub.setHora(5);

        GestorLlamadasTestable g = new GestorLlamadasTestable();
        g.setCalendario(stub);

        double res = g.calculaConsumo(10);
        assertEquals(5.0, res);
    }
}
