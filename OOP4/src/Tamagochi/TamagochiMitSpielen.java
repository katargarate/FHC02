package Tamagochi;

import java.util.Random;
import java.util.Scanner;

public class TamagochiMitSpielen {
    private int yCoord;
    private int xCoord;
    private int futterStand = 10; // gleich mit 10 füttern
    private char[][] feld = new char[5][7];
    private int maxFutter = 10;
    Scanner sc = new Scanner(System.in);

    public TamagochiMitSpielen() {
        startstelleSetzen();
        spielfeldZeichnen(yCoord, xCoord);
        spielen();

    }


    private void spielfeldZeichnen(int x, int y) {
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

    public void spielen() {
        while (true) {
            System.out.println("""
                    
                    Was wollen Sie tun?
                    1. Tamagochi füttern
                    2. Tamagochi bewegen
                    3. Beenden"""
            );

            System.out.print("Ihre Auswahl: ");

            int auswahl = sc.nextInt();

            switch (auswahl) {
                case 1:
                    if (futterStand < maxFutter) {
                        System.out.println("\nAktueller Futterstand: " + futterStand);

                        System.out.printf("\nWie viel wollen Sie füttern? (Max auf %d): ", maxFutter);
                        fuettern(sc.nextInt());

                        break;
                    }
                    System.out.println("Dein Tamagochi hat schon sein Maximum an Futter erreicht.\n");
                    break;

                case 2:
                    if (futterStand == 0) {
                        System.out.println("\nSie müssen ihr Tamagochi füttern bevor Sie ihn wieder bewegen können!");
                        return;
                    }
                    bewegen(gueltigeRichtungHolen());

                    break;

                case 3:
                    return; // end game

                default:
                    System.out.println("Ungueltige Auswahl. Versuchen Sie es nochmals");

            }
        }
    }

    private String gueltigeRichtungHolen() {
        while (true) {
            System.out.println("""
                    In welche Richtung wollen Sie ihr Tamagochi bewegen?
                    Nordlich = N, Südlich = S, Westlich = W, Östlich = O
                    """);

            System.out.print("Ihre Auswahl (N,S,W,O): ");

            String auswahl = sc.next().toUpperCase();

            sc.nextLine(); // clear buffer

            if (!auswahl.equals("N") && !auswahl.equals("W") && !auswahl.equals("S") && !auswahl.equals("O")) {
                System.out.println("Ungueltige Eingabe. Versuchen Sie es nochmals");
                continue;
            }

            return auswahl;
        }
    }


    private void bewegen(String richtung) {
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


    private boolean naechsterPlatzIstGueltig(int x, int y) {
        if (x >= 0 && x < 5 && y >= 0 && y < 7) return true;

        else {
            System.out.println("\nAchtung, in dieser Richtung gibt es eine Wand!\n");
            return false;
        }
    }

    private void fuettern(int futter) {
        futterStand += futter;

        if (futterStand > maxFutter) {
            System.out.printf("Achtung, dein Tamagochi kann nichts mehr essen. Futterstand bleibt bei %d.",maxFutter);
            futterStand = maxFutter; // max Futterstand = 10;
        }
    }


    private void startstelleSetzen() {
        // koordinaten dürfen nie 0 0 sein, werden Random erstellt
        Random r = new Random();

        do {
            yCoord = r.nextInt(0, 5);
            xCoord = r.nextInt(0, 7);
        } while (yCoord == 0 && xCoord == 0);
    }


}
