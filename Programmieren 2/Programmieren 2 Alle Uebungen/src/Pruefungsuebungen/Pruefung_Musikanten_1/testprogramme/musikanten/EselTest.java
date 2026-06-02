package Pruefungsuebungen.Pruefung_Musikanten_1.testprogramme.musikanten;

import Pruefungsuebungen.Pruefung_Musikanten_1.Esel;
import Pruefungsuebungen.Pruefung_Musikanten_1.Instrument;
import junit.framework.TestCase;
import org.junit.Test;

public class EselTest extends TestCase {

    static Instrument gitarre = new Instrument("Gitarre", 3.2);
    static Esel e1 = new Esel(4, gitarre, 4.5);

    @Test
    public void testEselRaeuberAnzahl() {
        double raeuber = e1.verscheucheRaeuber();
        assertEquals(18, raeuber, 0.01);


    }

    @Test
    public void testEselLautstaerke() {
        Instrument gitarre = new Instrument("Gitarre", 3.2);
        Esel e1 = new Esel(4, gitarre, 4.5);


        double lautstaerke = e1.spieleMusik();
        assertEquals(3.2, lautstaerke, 0.01);
    }



}