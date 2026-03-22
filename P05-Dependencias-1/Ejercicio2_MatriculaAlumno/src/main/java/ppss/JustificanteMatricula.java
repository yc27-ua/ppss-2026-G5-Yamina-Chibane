package ppss;

import java.util.ArrayList;
import java.util.List;

public class JustificanteMatricula {
    private List<String> asignaturas = new ArrayList<>();
    private List<String> errores = new ArrayList<>();

    public void addAsignatura(String a) { asignaturas.add(a); }
    public void addError(String e) { errores.add(e); }

    public List<String> getAsignaturas() { return asignaturas; }
    public List<String> getErrores() { return errores; }
}
