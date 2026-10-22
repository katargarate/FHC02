package Programmieruebungen5;
/*
Erstellen Sie eine Methode grundsteuerBerechnen() in der Klasse Grundsteuer.
Übergeben Sie ein zweidimensionales int Array welches mehrere Zeilen und 3 Spalten
aufweist:
• [1, 30, 40] Die drei Spalten sind Typ, Länge und Breite eines Grundstücks
Für jeden Quadratmeter Fläche muss eine gewisse Steuer bezahlt werden – die Höhe der
Steuer ist weiters vom Typ der Fläche abhängig:
• Typ 1: 3,20 Euro Steuer pro m2
• Typ2: 2,10 Euro Steuer pro m2
• Typ 3: 0,90 Euro Steuer pro m2
Liefern Sie als Rückgabewert die Summe der zu bezahlenden Steuer zurück. Erstellen Sie
an dieser Stelle auch eine TestGrund-Klasse, von welcher aus sie die Klasse
Grundsteuer aufrufen und die Methoden dieser ausgiebig testen.
 */
public class Grundsteuer {

    public double grundSteuerberechnen(int[][] arr ) {
        double summe = 0;
        for (int[] ints : arr) {
            int typ = ints[0];
            int flaeche = ints[1] * ints[2];

            if (typ == 1) summe += (double) flaeche * 3.2; // cast type for exact result

            else if (typ == 2) summe += (double) flaeche * 2.1;

            else summe += (double) flaeche * 0.9;

        }

        return summe;
    }
}
