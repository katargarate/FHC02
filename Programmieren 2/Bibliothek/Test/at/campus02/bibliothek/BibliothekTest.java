package at.campus02.bibliothek;

import at.campus02.bibliothek.Comparators.PreisComparator;
import at.campus02.bibliothek.Comparators.TitelComparator;
import at.campus02.bibliothek.Comparators.TypComparator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BibliothekTest {
    static Bibliothek bibliothek;
    static ArrayList<Medium> medien;
    static PreisComparator preisComparator;
    static TypComparator typComparator;
    static TitelComparator titelComparator;

    @BeforeEach
    void setUp() {
            Buch b1 = new Buch("Der Herr der Ringe", 1954, 19.54, "J.R.R. Tolkien", 400);
            Buch b2 = new Buch("Anderes Buch", 2020, 12.99, "Willi Thaler", 200);
            Buch b3 = new Buch("Noch einen Buch", 2000, 13.99, "HalliiHallo Thaler", 250);
            Film f1 = new Film("The Room", 2003, 9.99, "Tommy Wiseau", 99);
            Hoerbuch h1 = new Hoerbuch("Harry Potter und der Stein der Weisen", 1997, 29.99, "J.K. Rowling", 480);

            medien = new ArrayList<>();

            medien.add(b1);
            medien.add(b2);
            medien.add(b3);
            medien.add(f1);
            medien.add(h1);

            // Comparators erstellen
            preisComparator = new PreisComparator();
            typComparator = new TypComparator();
            titelComparator = new TitelComparator();
    }


    @Test
    void testSortierungNachErscheinungsjahr(){
        Collections.sort(medien);
        // erstes Erscheinungsjahr von der sortierte Liste zwischenspeichern
        int erstesErscheinungsJahr = medien.getFirst().getErscheinungsjahr();
        int letztesErscheinungsJahr = medien.getLast().getErscheinungsjahr();

        assertEquals(1954, erstesErscheinungsJahr); // gibt true zurück wenn es stimmt
        assertEquals(2020, letztesErscheinungsJahr);
    }

    @Test
    void testPreisComparator(){
        medien.sort(preisComparator); //inplace Sortierung mit preisComparator

        double billigstesPreis = medien.getFirst().getPreis();
        double teuersPreis = medien.getLast().getPreis();

        // testen, ob es stimmt
        assertEquals(9.99, billigstesPreis);
        assertEquals(29.99, teuersPreis);
    }

    @Test
    void testTypComparator(){
        medien.sort(typComparator);

        String erstesTyp = medien.getFirst().getMedientyp();
        String letztesTyp = medien.getLast().getMedientyp();

        assertEquals("Buch", erstesTyp);
        assertEquals("Hoerbuch", letztesTyp);
    }

    @Test
    void testTitelComparator(){
        medien.sort(titelComparator);

        String erstesTitel = medien.getFirst().getTitle();
        String letztesTitel = medien.getLast().getTitle();

        assertEquals("Anderes Buch", erstesTitel);
        assertEquals("The Room", letztesTitel);
    }



    @AfterEach
    void tearDown() {
        for (Medium m : medien){
            // wenn m ein Buch ist und ausgeliehen ist: zurückgeben
            if (m instanceof Buch && ((Buch) m).istAusgeliehen()){
                ((Buch) m).zurueckgeben();
            }
        }
    }
}