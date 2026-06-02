package Pruefungsuebungen.Pruefung_Musikanten_1;

import java.util.Comparator;

public class LautstaerkeComparator implements Comparator<Musikant> {

    // Absteigend sortiert
    @Override
    public int compare(Musikant m1, Musikant m2) {
        // hilsvariablen zum leichter Lesen
        double m1Lautstaerke = m1.instrument.getLautstaerke();
        double m2Lautstaerke = m2.instrument.getLautstaerke();

        if (m1Lautstaerke < m2Lautstaerke) return 1;
        if  (m1Lautstaerke > m2Lautstaerke) return -1;
        return 0; // wenn beide gleich laut sind
    }




}
