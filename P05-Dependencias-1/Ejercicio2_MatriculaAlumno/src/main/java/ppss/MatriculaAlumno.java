package ppss;

public class MatriculaAlumno {

    protected Operacion getOperacion() {
        return new Operacion();
    }

    public JustificanteMatricula validaAsignaturas(String dni, String[] asignaturas) {
        JustificanteMatricula j = new JustificanteMatricula();

        for (String a : asignaturas) {
            try {
                getOperacion().compruebaMatricula(dni, a);
                j.addAsignatura(a);
            } catch (AsignaturaIncorrectaException | AsignaturaCursadaException e) {
                j.addError(a);
            }
        }
        return j;
    }
}
