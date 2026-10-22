package Tamagochi;

import java.util.Scanner;

public class TamagochiMain {
    static Tamagochi tam = new Tamagochi();
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {


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
                    tamagochiFuettern();
                    break;
                case 2:
                    tamagochiBewegen();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ungueltige Auswahl. Versuchen Sie es nochmals");

            }
        }
    }

    private static void tamagochiBewegen() {
        if (tam.futterStand == 0) {
            System.out.println("\nSie müssen ihr Tamagochi füttern bevor Sie ihn wieder bewegen können!");
            return;
        }

        System.out.printf("\nAktuelle Koordinaten: x: %d, y: %d\n", tam.yCoord, tam.xCoord);

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

            // Methode aufrufen mit Richtung, die der Benutzer eingibt
            tam.bewegen(auswahl);
            break;
        }


    }

    public static void tamagochiFuettern() {
            // Aktueller Futterstand ausgeben
            System.out.println("\nAktueller Futterstand: " + tam.futterStand);

            System.out.print("\nWie viel wollen Sie füttern? (Max auf 10): ");
            int futterAnzahl = sc.nextInt();

            // im Instanz ändern
            tam.fuettern(futterAnzahl);
            System.out.println("\nNeuer Futterstand: " + tam.futterStand);

        }


}
