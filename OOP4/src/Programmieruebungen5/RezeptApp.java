package Programmieruebungen5;

public class RezeptApp {
    public static void main(String[] args) {

        // Testdaten erstellen
        String[] namen = {"Nudeln", "Tomatensoße", "Milch", "Parmesan"};
        double[][] zutaten = {
                {300, 1.0},  // Nudeln
                {100, 2.0},  // Tomatensoße
                {200, 1.5},  // Milch
                {150, 2.5}   // Käse
        };

        Rezept rezept = new Rezept(2, namen, zutaten);

        // ----------------------------
        System.out.println("TEST: kostet");
        System.out.println("Gesamtkosten: " + rezept.kostet());

        // ----------------------------
        System.out.println("\nTEST: kostetProPerson");
        System.out.println("Kosten pro Person: " + rezept.kostetProPerson());

        // ----------------------------
        System.out.println("\nTEST: allergisch");
        System.out.println("Allergisch gegen Milch? " + rezept.allergisch("Milch"));
        System.out.println("Allergisch gegen Reis? " + rezept.allergisch("Reis"));

        // ----------------------------
        System.out.println("\nTEST: aenderePersonen (2 -> 4)");
        rezept.aenderePersonen(4);

        System.out.println("Neue Personenanzahl: " + rezept.getAnzahlPersonen());
        System.out.println("Neue Gesamtkosten: " + rezept.kostet());
        System.out.println("Neue Kosten pro Person: " + rezept.kostetProPerson());

        // Zutaten nach Änderung anzeigen
        System.out.println("\nZutaten nach Skalierung:");
        for (int i = 0; i < zutaten.length; i++) {
            System.out.println(namen[i] + ": Menge=" + zutaten[i][0] + ", Preis=" + zutaten[i][1]);
        }

        // ----------------------------
        System.out.println("\nTEST: laktoseFrei");
        boolean entfernt = rezept.laktoseFrei();
        System.out.println("Wurde etwas entfernt? " + entfernt);

        // Zutaten nach laktosefrei anzeigen
        System.out.println("\nZutaten nach laktosefrei:");
        for (int i = 0; i < zutaten.length; i++) {
            System.out.println(namen[i] + ": Menge=" + zutaten[i][0] + ", Preis=" + zutaten[i][1]);
        }
    }
}
