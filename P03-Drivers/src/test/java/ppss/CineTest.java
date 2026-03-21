
package ppss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests asociados a la clase Cine")
public class CineTest {

    private Cine cine;

    @BeforeEach
    void setUp() {
        cine = new Cine();
    }

    // ======================
    // EJERCICIO 1 (C1–C4)
    // ======================

    @Test
    void C1_reservaButacas_should_return_Exception_when_fila_empty_and_want_3() {
        boolean[] asientos = new boolean[0];
        int solicitados = 3;

        ButacasException ex = assertThrows(ButacasException.class,
                () -> cine.reservaButacas(asientos, solicitados));

        assertEquals("No se puede procesar la solicitud", ex.getMessage());
    }

    @Test
    void C2_reservaButacas_should_return_false_when_fila_empty_and_want_zero() {
        boolean[] asientos = new boolean[0];
        int solicitados = 0;

        assertDoesNotThrow(() -> {
            boolean resultado = cine.reservaButacas(asientos, solicitados);

            assertAll("resultado y array",
                    () -> assertFalse(resultado),
                    () -> assertArrayEquals(new boolean[0], asientos)
            );
        });
    }

    @Test
    void C3_reservaButacas_should_return_true_when_fila_has_3_seats_free_and_want_2() {
        boolean[] asientos = new boolean[]{false, false, false, true, true};
        int solicitados = 2;

        boolean resultado = assertDoesNotThrow(() -> cine.reservaButacas(asientos, solicitados));

        assertAll("reserva correcta",
                () -> assertTrue(resultado),
                () -> assertArrayEquals(
                        new boolean[]{true, true, false, true, true},
                        asientos
                )
        );
    }

    @Test
    void C4_reservaButacas_should_return_false_when_no_free_seats_and_want_1() {
        boolean[] asientos = new boolean[]{true, true, true};
        int solicitados = 1;
        boolean[] copia = asientos.clone();

        boolean resultado = assertDoesNotThrow(() -> cine.reservaButacas(asientos, solicitados));

        assertAll("sin butacas libres",
                () -> assertFalse(resultado),
                () -> assertArrayEquals(copia, asientos)
        );
    }

    // ======================
    // EJERCICIO 3 (C5 - TABLA A)
    // ======================

    @Tag("parametrizado")
    @DisplayName("reservaButacas_")
    @ParameterizedTest(name = "{4}")
    @MethodSource("tablaA")
    void C5_reservaButacas(boolean[] asientos, int solicitados,
                           boolean expectedResult, boolean[] expectedArray,
                           String mensaje) throws ButacasException {

        boolean resultado = cine.reservaButacas(asientos, solicitados);

        assertAll(mensaje,
                () -> assertEquals(expectedResult, resultado),
                () -> assertArrayEquals(expectedArray, asientos)
        );
    }

    static Stream<Arguments> tablaA() {
        return Stream.of(
                Arguments.of(
                        new boolean[]{}, 0,
                        false,
                        new boolean[]{},
                        "Array vacío y 0 solicitados"
                ),
                Arguments.of(
                        new boolean[]{false, false, false, true, true}, 2,
                        true,
                        new boolean[]{true, true, false, true, true},
                        "Reserva 2 asientos"
                ),
                Arguments.of(
                        new boolean[]{true, true, true}, 1,
                        false,
                        new boolean[]{true, true, true},
                        "Sin asientos disponibles"
                )
        );
    }

    // ======================
    // EJERCICIO 3 (C6 - TABLA B)
    // ======================

    @Tag("parametrizado")
    @DisplayName("reservaButacas_")
    @ParameterizedTest(name = "{4}")
    @MethodSource("tablaB")
    void C6_reservaButacas(boolean[] asientos, int solicitados,
                           boolean expectedResult, boolean[] expectedArray,
                           String mensaje) throws ButacasException {

        boolean resultado = cine.reservaButacas(asientos, solicitados);

        assertAll(mensaje,
                () -> assertEquals(expectedResult, resultado),
                () -> assertArrayEquals(expectedArray, asientos)
        );
    }

    static Stream<Arguments> tablaB() {
        return Stream.of(
                Arguments.of(
                        new boolean[]{false, false, false}, 1,
                        true,
                        new boolean[]{true, false, false},
                        "Reserva 1 asiento"
                ),
                Arguments.of(
                        new boolean[]{true}, 1,
                        false,
                        new boolean[]{true},
                        "Asiento ocupado"
                )
        );
    }
}