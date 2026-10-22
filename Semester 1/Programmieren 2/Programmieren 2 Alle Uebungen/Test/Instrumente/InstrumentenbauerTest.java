package Instrumente;

import Pruefungsuebungen.Pruefung_Beispiel_Fuchs_3.Instrumente.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InstrumentenbauerTest {

    public static Instrumentenbauer ib; // damit es überall benutzt werden kann

    @BeforeAll
    static void init() {
        // 2 von jeden Instrumenten erstellen
        Instrument viola1 = new Viola("Viola", 5.0);
        Instrument viola2 = new Viola("Viola", 4.8);
        Instrument klavier1 = new Klavier("Klavier", 7.1);
        Instrument klavier2 = new Klavier("Klavier", 5.2);
        Instrument chello1 = new Chello("Chello", 5.4);
        Instrument chello2 = new Chello("Chello", 5.6);
        Instrument oboe1 = new Oboe("Oboe", 3.8);
        Instrument oboe2 = new Oboe("Oboe", 4.7);

        ib =  new Instrumentenbauer();

        // instrumente zum Array hinzufũgen (eine zu viel)
        ib.instrumentHinzufuegen(viola1);
        ib.instrumentHinzufuegen(viola2);
        ib.instrumentHinzufuegen(klavier1);
        ib.instrumentHinzufuegen(klavier2);
        ib.instrumentHinzufuegen(chello1);
        ib.instrumentHinzufuegen(chello2);
        ib.instrumentHinzufuegen(oboe1);
        ib.instrumentHinzufuegen(oboe2);
    }

    @Test
    public void testPrintInstrumentsByLoudness() {
        //liste sortieren
       Instrument[] sortierteInstrumente = ib.printInstrumentsByLoudness();

       // prüfen, ob das Instrument in der Stelle 0 die Lautstärke 3.8 hat (wenn ja = true)
       assertEquals(3.8, sortierteInstrumente[0].getLautstaerke());
    }

    @AfterAll
    static void tearDown() {
        ib = null; // löscht die Referenz nach jedem Testlauf
    }

}