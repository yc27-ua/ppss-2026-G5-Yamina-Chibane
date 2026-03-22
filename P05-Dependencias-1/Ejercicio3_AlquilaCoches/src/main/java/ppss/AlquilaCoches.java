package ppss;

import java.time.LocalDate;

public class AlquilaCoches {

    protected IService getServicio() {
        return new Servicio();
    }

    protected Calendario calendario = new Calendario();

    public Ticket calculaPrecio(TipoCoche tipo, LocalDate fecha, int dias) {
        float precio = getServicio().consultaPrecio(tipo);

        if (calendario.es_festivo(fecha)) {
            precio *= 1.2;
        }

        return new Ticket(precio * dias);
    }
}
