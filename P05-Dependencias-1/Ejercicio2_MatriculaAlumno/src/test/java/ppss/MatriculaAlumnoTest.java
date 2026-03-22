package ppss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OperacionStub extends Operacion {
    @Override
    public void compruebaMatricula(String dni, String asignatura)
            throws AsignaturaIncorrectaException, AsignaturaCursadaException {

        if (asignatura.equals("ZZ") || asignatura.equals("YYY")) {
            throw new AsignaturaIncorrectaException();
        }
        if (asignatura.equals("P1")) {
            throw new AsignaturaCursadaException();
        }
    }
}

class MatriculaAlumnoTestable extends MatriculaAlumno {
    Operacion op;
    public void setOperacion(Operacion o) { op = o; }
    @Override
    protected Operacion getOperacion() { return op; }
}

public class MatriculaAlumnoTest {

    @Test
    void C1_validaAsignaturas() {
        MatriculaAlumnoTestable m = new MatriculaAlumnoTestable();
        m.setOperacion(new OperacionStub());

        String[] asignaturas = {"MD", "ZZ", "FBD", "YYY", "P1"};
        JustificanteMatricula j = m.validaAsignaturas("00000000T", asignaturas);

        assertEquals(2, j.getAsignaturas().size());
        assertEquals(3, j.getErrores().size());
    }
}
