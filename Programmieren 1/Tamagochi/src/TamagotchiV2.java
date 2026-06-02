import java.util.Random;
import java.util.Scanner;

public class TamagotchiV2 {
    //fast alles gleich wie bei V1 - daher keine zusaetzlichen Kommentare
    private static final int BREITE = 7;
    private static final int HOEHE = 5;
    private char[][] spielfeld = new char[HOEHE][BREITE];
    private int futterstand = 10;
    private int punktestand = 0;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public TamagotchiV2() {
        initialisiereSpielfeld();
        platzierenTamagotchiUndPunkt();
    }

    // Initialisiert das Spielfeld mit *
    private void initialisiereSpielfeld() {
        for (int y = 0; y < HOEHE; y++) {
            for (int x = 0; x < BREITE; x++) {
                spielfeld[y][x] = '*';
            }
        }
    }

    // Setzt Tamagotchi und Punkt auf zufaellige Positionen
    private void platzierenTamagotchiUndPunkt() {
        int tamagotchiX, tamagotchiY, punktX, punktY;
        do {
            tamagotchiX = random.nextInt(BREITE);
            tamagotchiY = random.nextInt(HOEHE);
            punktX = random.nextInt(BREITE);
            punktY = random.nextInt(HOEHE);
        } while (tamagotchiX == punktX && tamagotchiY == punktY);

        spielfeld[tamagotchiY][tamagotchiX] = 'O'; // Tamagotchi setzen
        spielfeld[punktY][punktX] = '!'; // Zielpunkt setzen
    }

    // Zeichnet das Spielfeld in der Konsole
    public void SpielfeldZeichnen() {
        System.out.println("--Version 2--");
        for (int y = 0; y < HOEHE; y++) {
            for (int x = 0; x < BREITE; x++) {
                System.out.print(spielfeld[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println("Futterstand: " + futterstand);
        System.out.println("Punktestand: " + punktestand);
    }

    // Methode zum Bewegen des Tamagotchi
    public void Bewegen(String richtung) {
        int tamagotchiX = -1, tamagotchiY = -1;

        // Position des Tamagotchi finden
        for (int y = 0; y < HOEHE; y++) {
            for (int x = 0; x < BREITE; x++) {
                if (spielfeld[y][x] == 'O') {
                    tamagotchiX = x;
                    tamagotchiY = y;
                }
            }
        }

        int neueX = tamagotchiX;
        int neueY = tamagotchiY;

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

        //Pruefen ob wir gegen eine Wand laufen - Pruefung erfolgt quasi gleich wie bei V1
        if (neueX >= 0 && neueX < BREITE && neueY >= 0 && neueY < HOEHE) {
            //Hier haben wir die Besonderheit mit Arrays, etwas umstaendlicher als ohne
            spielfeld[tamagotchiY][tamagotchiX] = '*'; // Alte Position loeschen
            spielfeld[neueY][neueX] = 'O'; // Neue Position setzen
            futterstand--;

            //Falls wir den Punkt erreicht haben, Punkt erhoehen und Position neu setzen
            if (spielfeld[neueY][neueX] == '!') {
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
        int punktX, punktY;
        do {
            punktX = random.nextInt(BREITE);
            punktY = random.nextInt(HOEHE);
            //Solange an der gleichen Stelle wie das Tamagotchi - wiederholen!
        } while (spielfeld[punktY][punktX] == 'O');

        //Nun das neue Feld mit ! initalisieren, das Spielfeld wird spaeter neu gezeichnet
        spielfeld[punktY][punktX] = '!';
    }

    // Methode zum Fuettern des Tamagotchi
    public void Fuettern() {
        System.out.print("Geben Sie die Futtermenge ein: ");
        int menge = scanner.nextInt();
        if (menge > 0) {
            futterstand = Math.min(futterstand + menge, 10);
        }
    }

    // Hauptspiel-Loop
    public void spielen() {
        while (true) {
            SpielfeldZeichnen();
            System.out.println("Waehlen Sie: 1) Bewegen, 2) Fuettern, 3) Beenden");
            int wahl = scanner.nextInt();
            scanner.nextLine(); //Wenn ich das nicht mache, bekomme ich beim naechsten einen Fehler
            if (wahl == 1) {
                System.out.print("Richtung (oben, unten, links, rechts): ");
                String richtung = scanner.nextLine();
                Bewegen(richtung);
            } else if (wahl == 2) {
                Fuettern();
            } else if (wahl == 3) {
                System.out.println("Spiel beendet.");
                break;
            } else {
                System.out.println("Ungueltige Eingabe!");
            }
        }
    }
}