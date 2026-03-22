package ppss;

public class GestorLlamadas {

    protected Calendario getCalendario() {
        return new Calendario();
    }

    public double calculaConsumo(int minutos) {
        int hora = getCalendario().getHoraActual();
        if (hora >= 0 && hora < 8) {
            return minutos * 0.5;
        } else {
            return minutos * 1.5;
        }
    }
}
