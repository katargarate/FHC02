package WetterStation;

import java.util.Scanner;

public class WetterStationMain {
    /// SPEICHERN DES Temperaturs mit Monatsname:
    /*
     Da ein Wert ein String ist und der andere ein double, wäre es nicht möglich beide in einem Array zu speichern.
     Man könnte den Monat als double im Array speichern, aber ich fand das dann weniger sinnvoll.
     Ich habe das so gelöst, das ich,zusätzlich zu dem Array mit den Temperaturen, auch einen String Array mit
     Monatsnamen gemacht habe und die Monatsnamen bei Bedarf von da geholt habe.
     */

    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        // Test Temperatur Array zum testen
        //double[] testSample = {-15,-5,0,15,20,25,30,34,25,15,5,-20};

        // vom Benutzer 12 DurchSchnittstemperaturen einlesen und speichern
        double[] avgTemps = durchschnittsTemperaturenEinlesen();

        // Instanz erstellen, mit dem Array, der vom konstruktor erwartet ist
        WetterStation station = new WetterStation(avgTemps);

        System.out.printf("""
                
                Die durchschnittliche Jahrestemperatur beträgt: %.2f Grad
                Es gab %d kalte Monate und %d warme Monate.
                Der kälteste Monat war %s mit %.2f Grad.
                Der heißeste Monat war %s mit %.2f Grad.
                """, station.getJahresDurchschnitt(), station.getKalteMonateAnzahl(), station.getWarmeMonateAnzahl(),
                monatNameVonInt(station.getKaeltestesMonat()), station.entsprechendeTemperaturFinden(station.getKaeltestesMonat()),
                monatNameVonInt(station.getWaermstesMonat()), station.entsprechendeTemperaturFinden(station.getWaermstesMonat())
                );
    }

    // Helfer Methode um den Monatsnamen von einem Integer zu bekommen (1 = Jänner, 2 = Februar, etc)
    public static String monatNameVonInt(int num) {
        String[] monate = {"Jänner","Februar", "März", "April", "Mai", "Juni", "Juli",
                "August", "September", "Oktober", "November", "Dezember" };
        return monate[num];
    }

    public static double[] durchschnittsTemperaturenEinlesen() {
        double[] temps = new double[12];

        // for-loop um 12 Mal vom Benutzer eine Durchschnittstemperatur einzulesen
        for (int i = 0; i < temps.length; i++) {
            System.out.printf("Durchschnittstemperatur für %s eingeben: ", monatNameVonInt(i));
            temps[i] = sc.nextDouble(); // Eingabe im Array speichern
        } return temps;
    }
}
