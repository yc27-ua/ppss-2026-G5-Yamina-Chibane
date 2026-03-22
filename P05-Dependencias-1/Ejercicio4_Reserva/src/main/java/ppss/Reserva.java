package ppss;

public class Reserva {

    protected IOperacionBO getOperacion() { return null; }

    public boolean compruebaPermisos(String login, String password) {
        return true;
    }

    public void realizaReserva(String login, String password, String socio, String[] isbns)
            throws ReservaException {

        if (!compruebaPermisos(login, password)) {
            throw new ReservaException();
        }

        for (String isbn : isbns) {
            try {
                getOperacion().operacionReserva(socio, isbn);
            } catch (Exception e) {
                throw new ReservaException();
            }
        }
    }
}
