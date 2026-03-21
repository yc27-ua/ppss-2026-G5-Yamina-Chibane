package ppss;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FicheroTextoTest {

    @Test
    void C1_contarCaracteres_should_return_Exception_when_file_does_not_exist() {
        // Arrange
        FicheroTexto sut = new FicheroTexto();
        String fileName = "src/test/resources/ficheroC1.txt";

        // Act & Assert
        FicheroException ex = assertThrows(FicheroException.class, () -> sut.contarCaracteres(fileName));
        assertEquals("src/test/resources/ficheroC1.txt (No existe el archivo o el directorio)", ex.getMessage());
    }

    @Test
    void C2_contarCaracteres_should_return_4_when_file_has_4_chars() {
        // Arrange
        FicheroTexto sut = new FicheroTexto();
    String fileName = "src/test/resources/ficheroCorrecto.txt";

        // Act & Assert
        try {
            int resultado = sut.contarCaracteres(fileName);
            assertEquals(4, resultado);
        } catch (FicheroException e) {
            fail("No se esperaba excepción: " + e.getMessage());
        }
    }

    @Test
    @Tag("excluido")
    void C3_contarCaracteres_should_return_Exception_when_file_cannot_be_read() {
        fail("No implementado");
    }

    @Test
    @Tag("excluido")
    void C4_contarCaracteres_should_return_Exception_when_file_cannot_be_closed() {
        fail("No implementado");
    }
}
