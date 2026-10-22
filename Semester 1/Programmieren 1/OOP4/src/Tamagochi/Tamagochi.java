package Tamagochi;

import java.util.Arrays;
import java.util.Random;

public class Tamagochi {
    public int yCoord;
    public int xCoord;
    public int futterStand = 10; // gleich mit 10 füttern
    private char[][] feld = new char[5][7];
    private int maxFutter = 10;

    public Tamagochi() {
        startstelleSetzen();
        spielfeldZeichnen(yCoord, xCoord);
    }


    public void spielfeldZeichnen(int x, int y) {
        // first fill everything with *
        for (int i = 0;  i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == x && j == y) {
                    System.out.print("O ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }


    public void bewegen(String richtung) {
        switch (richtung.toUpperCase()) {
            case "N": // North = up
                if (naechsterPlatzIstGueltig(yCoord - 1, xCoord)) {
                    yCoord -= 1;
                    fuettern(-1);
                }
                break;
            case "S": // South = down
                if (naechsterPlatzIstGueltig(yCoord + 1, xCoord)) {
                    yCoord += 1;
                    fuettern(-1);
                }
                break;
            case "W": // West = left
                if (naechsterPlatzIstGueltig(yCoord, xCoord - 1)) {
                    xCoord -= 1;
                    fuettern(-1);
                }
                break;
            case "O": // Ost = right
                if (naechsterPlatzIstGueltig(yCoord, xCoord + 1)) {
                    xCoord += 1;
                    fuettern(-1);
                }
                break;
            default:
                System.out.println("Ungültige Richtung!");
        }

        System.out.println("Neuer Spielfeld:");
        spielfeldZeichnen(yCoord, xCoord);
    }


    public boolean naechsterPlatzIstGueltig(int x, int y) {
        if (x >= 0 && x < 5 && y >= 0 && y < 7) return true;

        else {
            System.out.println("\nAchtung, in dieser Richtung gibt es eine Wand!\n");
            return false;
        }
    }

    public void fuettern(int futter) {
        // Abbrechen, wenn Futterstand schon am Maximum ist
        if (futterStand >= maxFutter) {
            System.out.println("Dein Tamagochi hat schon sein Maximum an Futter erreicht.\n");
            return;
        }
        // sonst updaten
        futterStand += futter;

        // wenn futterstand dann über 10 ist, Meldung drucken und auf 10 setzen
        if (futterStand > maxFutter) {
            System.out.printf("Achtung, dein Tamagochi kann nichts mehr essen. Futterstand bleibt bei %d.", maxFutter);
            futterStand = maxFutter; // max Futterstand = 10;
        }
    }


    private void startstelleSetzen() {
        Random r = new Random();

        do {
            yCoord = r.nextInt(0, 5);
            xCoord = r.nextInt(0, 7);
        } while (yCoord == 0 && xCoord == 0);
    }

    // koordinaten dürfen nie 0 0 sein, werden Random erstellt
}
