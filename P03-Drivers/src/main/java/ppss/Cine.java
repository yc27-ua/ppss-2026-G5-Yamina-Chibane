package ppss;

public class Cine {
    public boolean reservaButacas(boolean[] asientos, int solicitados) throws ButacasException {
        boolean reserva = false;
        // Caso trivial: solicitar <= 0 no modifica nada
        if (solicitados <= 0) {
            return false;
        }

        // Si no hay asientos y se solicitan >0, es error según enunciado
        if (asientos == null || asientos.length == 0) {
            throw new ButacasException("No se puede procesar la solicitud");
        }

        int j = 0;
        int sitiosLibres = 0;
        int primerLibre;

        while ((j < asientos.length) && (sitiosLibres < solicitados)) {
            if (!asientos[j]) {
                sitiosLibres++;
            } else {
                sitiosLibres = 0;
            }
            j++;
        }
        if (sitiosLibres == solicitados) {
            primerLibre = (j - solicitados);
            reserva = true;
            // Reservar exactamente 'solicitados' butacas (usar <, no <=)
            for (int k = primerLibre; k < (primerLibre + solicitados); k++) {
                asientos[k] = true;
            }
        }

        return reserva;
    }
}
