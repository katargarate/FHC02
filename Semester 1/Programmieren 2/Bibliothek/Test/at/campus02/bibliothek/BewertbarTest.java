package at.campus02.bibliothek;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BewertbarTest {
    Film f1;

    @BeforeEach
    void setUp() {
        f1 = new Film("The Room", 2003, 9.99, "Tommy Wiseau", 99);
    }

    @Test
    void setBewertung() {
        f1.setBewertung(5);

        assertEquals(5, f1.getBewertung()); // wenn funktioniert hat -> test passed

        f1.setBewertung(6);
        assertEquals(5, f1.getBewertung()); // sollte noch bei 5 sein, weil 6 nicht erlaubt ist
    }

    @AfterEach
    void tearDown() {
        f1 = null;
    }
}