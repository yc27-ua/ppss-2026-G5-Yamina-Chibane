package ppss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperacionStub implements IOperacionBO {
    public void operacionReserva(String socio, String isbn)
            throws IsbnInvalidoException, SocioInvalidoException {

        if (isbn.equals("33333")) throw new IsbnInvalidoException();
        if (socio.equals("Pepe")) throw new SocioInvalidoException();
    }
}

class ReservaTestable extends Reserva {
    IOperacionBO op;
    boolean permiso;

    public void setOperacion(IOperacionBO o) { op = o; }
    public void setPermiso(boolean p) { permiso = p; }

    @Override
    protected IOperacionBO getOperacion() { return op; }

    @Override
    public boolean compruebaPermisos(String login, String password) {
        return permiso;
    }
}

public class ReservaTest {

    @Test
    void C1_sin_permiso() {
        ReservaTestable r = new ReservaTestable();
        r.setPermiso(false);
        r.setOperacion(new OperacionStub());

        assertThrows(ReservaException.class, () ->
            r.realizaReserva("x","x","Luis", new String[]{"111"})
        );
    }
}
