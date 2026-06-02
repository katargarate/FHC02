import java.util.Random;
import java.util.Scanner;

public class TamagotchiV1 {
    //Durch final, kann die Variable im Spiel nicht mehr geaendert werden
    private static final int BREITE = 7; // Spielfeldbreite fixiert!
    private static final int HOEHE = 5;  // Spielfeldhoehe fixiert!
    //Tamagotchi-Koordinaten
    private int tamagotchiX, tamagotchiY;
    //Punkt-Koordinaten, der sich dann immer wieder neu setzt, wenn erreicht
    private int punktX, punktY;
    //Kann von User nachgefuellt werden
    private int futterstand = 10; //Anfangswert von Futterstand
    private int punktestand = 0; //Fuer das Sammeln von Punkten
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    //Der Konstruktor fuehrt sofort das Punktesetzen durch, so wie das Objekt erstellt wird
    public TamagotchiV1() {
        platzierenTamagotchiUndPunkt();
    }

    //Setzt Tamagotchi und Punkt auf zufaellige Positionen
    private void platzierenTamagotchiUndPunkt() {
        //Fuehre solange aus bis beide Punkte x und y Koordinaten ungleich!
        do {
            tamagotchiX = random.nextInt(BREITE); //Maximal die Breite
            tamagotchiY = random.nextInt(HOEHE); //Maximal die Hoehe
            punktX = random.nextInt(BREITE);
            punktY = random.nextInt(HOEHE);
        } while (tamagotchiX == punktX && tamagotchiY == punktY);
    }

    //Zeichnet das Spielfeld in der Konsole
    public void SpielfeldZeichnen() {
        //Verschachtelte For-Schleife notwendig, da es ein 2D-Feld ist
        for (int y = 0; y < HOEHE; y++) {
            for (int x = 0; x < BREITE; x++) {
                if (x == tamagotchiX && y == tamagotchiY) {
                    System.out.print("O "); // Tamagotchi
                } else if (x == punktX && y == punktY) {
                    System.out.print("! "); // Zielpunkt
                } else {
                    System.out.print("* "); // Leeres Feld
                }
            }
            System.out.println();
        }
        System.out.println("Futterstand: " + futterstand);
        System.out.println("Punktestand: " + punktestand);
    }

    //Methode zum Bewegen des Tamagotchi
    public void Bewegen(String richtung) {
        int neueX = tamagotchiX;
        int neueY = tamagotchiY;

        //Hier wird geschaut in welche Richtung der User gehen moechte
        switch (richtung.toLowerCase()) {
            case "links":
                neueX--;
                break;
            case "rechts":
                neueX++;
                break;
            case "oben":
                neueY--;
                break;
            case "unten":
                neueY++;
                break;
            default:
                System.out.println("Ungueltige Richtung!");
                return;
        }

        //Pruefen ob wir nicht an eine Wand laufen - schaut komplex aus ist es aber nicht
        //Nur wenn X und Y innerhalb des Feldes sind, gehen wir den Schritt und ziehen Futter ab
        if (neueX >= 0 && neueX < BREITE && neueY >= 0 && neueY < HOEHE) {
            tamagotchiX = neueX;
            tamagotchiY = neueY;
            futterstand--;
            //Pruefen ob wir den Punkt erreicht und gewonnen haben, wenn sich die beiden
            //Koordinaten der Punkte decken, dann Punktestand hochzahlen und Punkt neu setzen
            if (tamagotchiX == punktX && tamagotchiY == punktY) {
                System.out.println("Tamagotchi hat das Ziel erreicht!");
                punktestand++;
                platzierenNeuesZiel();
            }
        } else {
            System.out.println("Achtung, in dieser Richtung ist eine Wand!");
        }
    }

    // Setzt einen neuen Zielpunkt
    private void platzierenNeuesZiel() {
        //Punkt neu positionieren, darf nicht gleich Tamagotchi-Positon sein!
        do {
            punktX = random.nextInt(BREITE);
            punktY = random.nextInt(HOEHE);
            //Mache solange weiter, bis nachfolgende Bedingung false!
        } while (tamagotchiX == punktX && tamagotchiY == punktY);
    }

    // Methode zum Fuettern des Tamagotchi
    public void Fuettern() {
        System.out.print("Geben Sie die Futtermenge ein: ");
        int menge = scanner.nextInt();
        if (menge > 0) {
            //Funktion verhindert, dass wir mehr als 10 in futterstand speichern
            //etwas weniger umstaendlich als wenn wir mehrere IFs verwenden
            futterstand = Math.min(futterstand + menge, 10);
        }
    }

    // Hauptspiel-Loop - Dieser rennt solange, bis user die Zahl 3 eingibt
    public void spielen() {
        while (true) {
            //Jede Runde muss neu gezeichnet werden
            SpielfeldZeichnen();
            System.out.print("Waehlen Sie: 1) Bewegen, 2) Fuettern, 3) Beenden => ");
            int wahl = scanner.nextInt();
            scanner.nextLine(); // Puffer leeren, damit scanner gleich wieder verwendet werden kann
            if (wahl == 1) {
                System.out.print("Richtung (oben, unten, links, rechts): ");
                String richtung = scanner.nextLine();
                //Bewegung an entsprechende Methode weitergeben
                Bewegen(richtung);
            } else if (wahl == 2) {
                Fuettern();
            } else if (wahl == 3) {
                System.out.println("Spiel beendet.");
                break; //Erst mit diesen Break wird das Spiel beendet!
            } else {
                System.out.println("Ungueltige Eingabe!");
            }
        }
    }
}
