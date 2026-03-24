import java.util.Scanner;

public class InventorySpiel {
    int apfelStand;
    int goldStand;

    // Konstruktor
    public InventorySpiel(int goldStand) {
        this.apfelStand = 0; // apfelstand am spielanfang immer bei 0
        this.goldStand = goldStand; // vom Benutzer beim Erstellen übermittelt

        infoAusgeben(); // gleich beim Erstellen diese Methode aufrufen um alle Infos ausgeben
    }

    // Spiel Methode

    public void spielen() {
        boolean gameIsRunning = true;

        Scanner sc = new Scanner(System.in);
        while (gameIsRunning) {
            System.out.printf("""
                    
                    ** HAUPTMENÜ **
                    1. Goldstand Prüfen
                    2. Apfelstand Prüfen
                    3. Apfel kaufen
                    4. Apfel essen
                    5. Beenden 
                    
                    """);

            System.out.print("Ihr Auswahl: ");
            int auswahl = sc.nextInt();

            switch (auswahl) {
                case 1:
                    System.out.println("\nAktueller Goldstand: " + getGoldstand());
                    break;
                case 2:
                    System.out.println("\nAktueller Apfelstand: " + getApfelStand());
                    break;
                case 3:
                    System.out.print("\nWie viele Äpfel willst du kaufen?: ");
                    apfelKaufen(sc.nextInt()); // ruf Methode auf mit Benutzereingabe als Argument
                    break;
                case 4:
                    System.out.println("\nMampf, ein Apfel wird gegessen!");
                    apfelEssen();
                    break;
                case 5:
                    gameIsRunning = false; // While-Bedingung auf False setzen, Schleife wird daher beendet
                    break; // programm beenden
                default:
                    System.out.println("Ungültige Eingabe - versuchen Sie es nochmals.");
                    // hier brauchen wir kein continue, weil in der while-schleife kein weiterer Code folgt,
                    // d.h. wir kommen sowieso gleich zur nächsten Iteration
            }


        }
        System.out.println("Goodbye!"); // wird nach Abbrechen der While-Schleife ausgegeben

    }

    public int getApfelStand() {
        // hier wird Apfelstand retour geschickt
        return apfelStand;
    }

    public int getGoldstand() {
        // hier wird Goldstand retour geschickt
        return goldStand;
    }

    public void apfelEssen() {
        // hier wird ein Apfel vom Apfelstand abgezogen
        // zuerst prüfen, ob es mind 1 Apfel gibt

        if (apfelStand >= 1) {
            apfelStand--;
            // auch möglich: apfelstand = apfelstand -1;
            // auch möglich: apfelstand -= 1;
            System.out.println("Neuer Apfelstand: " + apfelStand);
        } else {
            System.out.println("Nicht genug Äpfel.");
        }
    }

    public void apfelKaufen(int anzahl) {
        // hier wird ein Apfel zum Apfelstand hinzugefügt und 2 * Gold vom Geldstand abgezogen
        // zuerst überprüfen, ob genug geld da ist
        int preisProApfel = 2;
        int gesamtPreis = anzahl * preisProApfel;

        if (goldStand >= gesamtPreis) {
            apfelStand += anzahl; // heißt: apfelStand = apfelStand + anzahl;
            goldStand -= anzahl * preisProApfel;
            System.out.printf("Sie haben um %d Stück Gold %d Äpfel gekauft.\n", gesamtPreis,anzahl);
        }

    }

    public void infoAusgeben() {
        System.out.printf("""
                ** ALLE INFOS **
                
                Goldstand: %d
                Apfelstand: %d
                """, goldStand, apfelStand);
    }



}
