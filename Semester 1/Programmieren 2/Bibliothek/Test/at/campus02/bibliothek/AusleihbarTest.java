package at.campus02.bibliothek;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AusleihbarTest {
    Buch b1;

    @BeforeEach
    void setUp() {
        b1 = new Buch("Der Herr der Ringe", 1954, 19.54, "J.R.R. Tolkien", 400);
    }


    @Test
    void testIstAusgeliehenInitial() {
        // sollte initial nicht ausgeliehen sein, also wenn true retour kommt -> failed test
        assertFalse(b1.istAusgeliehen());
    }

    @Test
    void testAusleihen() {
        b1.ausleihen("Max Mustermann");

        assertEquals("Max Mustermann", b1.getAusleieher());
        assertTrue(b1.istAusgeliehen()); // true wenn ausgeliehen = true
    }


    @AfterEach
    void tearDown() {
        b1 = null;
    }

}