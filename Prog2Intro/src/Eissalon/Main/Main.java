package Eissalon.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private EissorteManager manager = new EissorteManager();

    public Main() {
        Eissorte e1 = new Eissorte("Chocolate", 1.2);
        Eissorte e2 = new Eissorte("Pineapple", 1.1);
        Eissorte e3 = new Eissorte("Vanilla", 1.3);
        Eissorte e4 = new Eissorte("Banana", 1.0);

        manager.eissorteHinzufuegen(e1);
        manager.eissorteHinzufuegen(e2);
        manager.eissorteHinzufuegen(e3);
        manager.eissorteHinzufuegen(e4);
    }

    void main() {
        runMenu();
    }


    public void runMenu() {
        Scanner sc = new Scanner(System.in);

        // wiederhole, bis exit ausgewählt wird und das System somit beendet wird
        while (true) {
            System.out.println("""
                MENU:
                A: Eissorten Sortiert Nach Name
                B: Eissorten Aufsteigend Nach Preis Sortiert
                C: Eissorten Absteigend Nach Preis Sortiert
                X: Exit
                """);

            System.out.print("Auswahl: ");
            char auswahl = sc.next().toUpperCase().charAt(0); // char Eingabe einlesen

            // Option ausführen, wenn null zurückkommt, Schleife beenden
            if (optionAusfuehren(auswahl) == null) {
                break;
            }

        }
    }

    public List<Eissorte> optionAusfuehren(char auswahl) {

        boolean ungueltig = false;
        List<Eissorte> sortierteListe = new ArrayList<>(); // liste definieren
        String titel = "";

        // passendes titel und sortierte Liste speichern
        switch (auswahl) {
            case 'A':
                sortierteListe = manager.getEissortenSortiertNachName();
                titel = "Nach Name Sortiert";
                break;
            case 'B':
                sortierteListe = manager.getEissortenSortiertNachPreis(true);
                titel = "Nach Preis Aufsteigend Sortiert";
                break;
            case 'C':
                sortierteListe = manager.getEissortenSortiertNachPreis(false);
                titel = "Nach Preis Absteigend Sortiert";
                break;
            case 'X':
                System.exit(0); // programm beenden
                return null;
            default:
                System.out.println("Ungültige Eingabe. Versuchen Sie es nochmals.\n");
                ungueltig = true;
                break;

        }
        // Liste ausgeben, wenn die Option gültig war
        if (!ungueltig) {
            listeAusgeben(sortierteListe,titel);
        }
        return sortierteListe;

    }

    private void listeAusgeben(List<Eissorte> sortierteListe, String titel) {
        System.out.printf("\n-- %s --\n",titel);

        for (Eissorte eissorte : sortierteListe) {
            System.out.println(eissorte);
        }

        System.out.println(); // leere Zeile
    }

}
