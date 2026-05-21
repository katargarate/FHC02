package Eissalon.Test;

import Eissalon.Main.Eissorte;
import Eissalon.Main.EissorteManager;
import Eissalon.Main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class EissorteManagerTest {
    Main main;
    EissorteManager manager;

    @BeforeEach
    void setUp() {

        manager = new EissorteManager();

        manager.eissorteHinzufuegen(new Eissorte("Pineapple", 1.10));
        manager.eissorteHinzufuegen(new Eissorte("Chocolate", 1.20));
        manager.eissorteHinzufuegen(new Eissorte("Vanilla", 1.30));
        manager.eissorteHinzufuegen(new Eissorte("Banana", 1.00));

    }

    @Test
    void PreisAufsteigendSortierungTest() {
        Main main = new Main();

        List<Eissorte> eisListeASC = main.optionAusfuehren('B');
        // prüfen, ob erster Preis = 1.0
        Assertions.assertEquals(1.0, eisListeASC.getFirst().getPreis());
    }

}