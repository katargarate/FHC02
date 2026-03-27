package WetterStation;

public class WetterStation {
    double[] avgTemps;
    final int MONTHS_IN_A_YEAR = 12; // als konstante Variable deklarieren
    private double jahresDurchschnitt;

    private int warmeMonateAnzahl; // anzahl Monate >= 30 Grad
    private int kalteMonateAnzahl;// anzahl Monate < 0 Grad

    private int waermstesMonat; // position der wärmste Monat
    private int kaeltestesMonat; // position der kälteste Monat

    public WetterStation(double[] avgTemps) {
        this.avgTemps = avgTemps;

        // beim Konstruktor diese Methoden aufrufen, um die Werte zu initialisieren
        kalteUndWarmeMonateCounter();
        jahresDurchschnitt = jahresTemperaturDurchschnittBerechnen();
        waermstesMonat = waermstestesMonatFinden();
        kaeltestesMonat = kaeltestesMonatFinden();
    }

    public double entsprechendeTemperaturFinden(int position) {
        return avgTemps[position]; // Stelle im Array suchen
        // bsp. Jänner = Monat 1 = Position 0 im Array - also Wert von Position 0 wird retour geschickt
    }

    private double jahresTemperaturDurchschnittBerechnen(){
        double summe = 0;

        // foreach schleife durch alle temps werte
        for (double t : avgTemps) {
            summe += t; // Aktueller Wert zu Summe addieren
        }
        return (double) summe / MONTHS_IN_A_YEAR;  // als double casten sonst wird es gerundet
    }


    private void kalteUndWarmeMonateCounter() {
        // Globale Counters bei 0 initialisieren
        warmeMonateAnzahl = 0;
        kalteMonateAnzahl = 0;

        // mit einem for-loop alle Durchschnittstemperaturen überprüfen
        for (int i = 0; i < avgTemps.length; i++) {
            if (avgTemps[i] >= 30) { // wenn der aktuelle Wert über 30 ist:
                warmeMonateAnzahl++; // warme Monate counter inkrementieren
            } else if (avgTemps[i] < 0) kalteMonateAnzahl++; // sonst wenn es minus 0 ist, kalteMonate counter inkrementieren
        }

    }

    private int waermstestesMonatFinden() {
        int maxTempStelle = 0; // mit der ersten Position initialisieren
        double maxTemp = avgTemps[0]; // mut den ersten Wert init.

        for (int i = 0; i < avgTemps.length; i++) {
            if (avgTemps[i] > maxTemp) {
                maxTemp = avgTemps[i]; // max Temp auf diesen Wert setzen (für späteren Vergleich)
                maxTempStelle = i; // markiere auch die Stelle
            }
        } return maxTempStelle; // die Stelle im Array zurückgeben, nicht die Temperatur
    }

    private int kaeltestesMonatFinden() {
        int minTempStelle = 0; // mit der ersten Position initialisieren
        double minTemp = avgTemps[0]; // mit den ersten Wert init.

        for (int i = 0; i < avgTemps.length; i++) {
            if (avgTemps[i] < minTemp) {
                minTemp = avgTemps[i]; // min Temp auf diesen Wert setzen (für späteren Vergleich)
                minTempStelle = i; // markiere auch die Stelle
            }
        } return minTempStelle; // die Stelle im Array zurückgeben, nicht die Temperatur
    }


    // GETTERS für die Warme/Kalte Monat Counters, damit die privaten Felder noch greifbar sind

    public int getWarmeMonateAnzahl() {
        return warmeMonateAnzahl;
    }

    public int getKalteMonateAnzahl() {
        return kalteMonateAnzahl;
    }

    public double getJahresDurchschnitt() {
        return jahresTemperaturDurchschnittBerechnen();
    }


    public int getWaermstesMonat() {
        return waermstesMonat;
    }

    public int getKaeltestesMonat() {
        return kaeltestesMonat;
    }
}
