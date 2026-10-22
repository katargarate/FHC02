package Pruefungsuebungen.Pruefung_Beispiel_Fuchs_3.Instrumente;

import java.util.Arrays;

public class Instrumentenbauer {
    private Instrument[] instrumente = new Instrument[7];

    public void instrumentHinzufuegen(Instrument instrument) {
        // wenn die Liste schon voll ist, Error ausgeben
        if (instrumente[instrumente.length-1] != null) {
            System.err.printf("\nListe schon voll. Es können nur 7 Instrumente hinzugefügt werden. %s wird nicht hinzugefügt\n",
                    instrument.getName());
            return; // aus der Methode rausspringen
        }

        // sonst erstes freies Platz im Array finden und zuweisen
        for (int i = 0; i < instrumente.length; i++){
            if (instrumente[i] == null){
                instrumente[i] = instrument;
                System.out.printf("%s in der Stelle %d hinzugefügt\n", instrument.getName(), i);
                break; // aus der Schleife rausspringen, damit nicht mehrere Plätze belegt werden
            }
        }

    }

    public Instrument[] printInstrumentsByLoudness() {
        Arrays.sort(instrumente); // benutzt die Comparable methode in Instrument

        // sortierte Liste ausgeben
        System.out.println("\nInstrumente sortiert nach Lautstärke:");
        for (Instrument i : instrumente) {
            System.out.println(i);
        }
        return instrumente;

    }
}
