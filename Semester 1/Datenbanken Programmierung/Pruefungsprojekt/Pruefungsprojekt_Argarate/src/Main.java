import Controller.DBHelper;
import Model.Ausleihe;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final DBHelper dbHelper = new DBHelper();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        dbHelper.openConnection();
        dbHelper.setup();

        boolean beenden = false;
        while (!beenden) {
            zeigeMenue();
            String eingabe = scanner.nextLine().trim();

            switch (eingabe) {
                // ===== CRUD für Ausleihen =====
                case "1" -> {
                    Ausleihe neueAusleihe = leseAusleiheDaten();
                    dbHelper.insertAusleihe(neueAusleihe);
                    System.out.println("Ausleihe wurde eingefügt mit AusleihID: " + neueAusleihe.getAusleihId());
                }
                case "2" -> {
                    System.out.print("\nAusleihID eingeben: ");
                    int ausleihId = leseInt();
                    Ausleihe bestehende = dbHelper.getAusleiheByID(ausleihId);
                    if (bestehende == null) {
                        System.out.println("Ausleihe nicht gefunden.");
                    } else {
                        Ausleihe aktualisiert = leseAusleiheDaten();
                        aktualisiert.setAusleihId(ausleihId);
                        int affectedRows = dbHelper.updateAusleihe(aktualisiert);
                        System.out.println(affectedRows > 0 ? "Ausleihe wurde aktualisiert." : "Ausleihe nicht gefunden.");
                    }
                }
                case "3" -> {
                    System.out.print("\nAusleihID zum Löschen eingeben: ");
                    int ausleihId = leseInt();
                    int affectedRows = dbHelper.deleteAusleihe(ausleihId);
                    System.out.println(affectedRows > 0 ? "Ausleihe wurde gelöscht." : "Ausleihe nicht gefunden.");
                }
                case "4" -> {
                    System.out.print("\nAusleihID eingeben: ");
                    int ausleihId = leseInt();
                    System.out.println("\n"+dbHelper.getAusleiheAnzeigeByID(ausleihId));
                }
                // ===== Auswertungsmethoden =====
                case "5" -> {
                    System.out.println("\nAktuell offene Ausleihen:");
                    printListe(dbHelper.getAktuellOffeneAusleihen());
                }
                case "6" -> {
                    System.out.println("\nAnzahl Ausleihen pro Skate-Größe:");
                    printHashMapFloat(dbHelper.getAnzahlAusleihenProSkateGroesse());
                }
                case "7" -> {
                    System.out.print("\nWie viele Top-Skates anzeigen? ");
                    int limit = leseInt();
                    System.out.println("Beliebteste Skates:");
                    printListe(dbHelper.getBeliebtesteSkates(limit));
                }
                case "8" -> {
                    float auslastung = dbHelper.getAuslastungProzent();
                    System.out.printf("\nAktuelle Auslastung des Skate-Bestands: %.1f%%%n", auslastung);
                }

                // ===== Transaktionen =====
                case "9" -> {
                    System.out.print("\nSkateID zum Entfernen: ");
                    int skateId = leseInt();
                    dbHelper.skateEntfernen(skateId);
                }
                case "10" -> {
                    System.out.print("\nAusleihID: ");
                    int ausleihId = leseInt();
                    System.out.print("Rückgabedatum (YYYY-MM-DD): ");
                    String rueckgabedatum = scanner.nextLine().trim();
                    dbHelper.skateZurueckgeben(ausleihId, rueckgabedatum);                }

                // ===== Metadaten =====
                case "11" -> dbHelper.printSkatesMetadata();
                case "12" -> dbHelper.printForeignKeysVonAusleihen();

                case "0" -> {
                    beenden = true;
                    dbHelper.closeConnection();
                    System.out.println("\nProgramm wird beendet.");
                }
                default -> System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
            }

            System.out.println(); // Leerzeile zur besseren Lesbarkeit zwischen Menü-Durchläufen
        }
    }

    private static void zeigeMenue() {
        System.out.println("===== Skateverleih Navigationsmenü =====");
        System.out.println("--- CRUD Ausleihen ---");
        System.out.println("1  - Neue Ausleihe anlegen");
        System.out.println("2  - Ausleihe aktualisieren");
        System.out.println("3  - Ausleihe löschen");
        System.out.println("4  - Ausleihe per ID anzeigen");
        System.out.println("--- Auswertungen ---");
        System.out.println("5  - Aktuell offene Ausleihen anzeigen (JOIN)");
        System.out.println("6  - Anzahl Ausleihen pro Skate-Größe (GROUP BY)");
        System.out.println("7  - Beliebteste Skates anzeigen (ORDER BY)");
        System.out.println("8  - Auslastung des Skate-Bestands anzeigen (berechnete Spalte)");
        System.out.println("--- Transaktionen ---");
        System.out.println("9  - Skate entfernen (schließt offene Ausleihe automatisch)");
        System.out.println("10 - Skate zurückgeben (Ausleihe + Skate-Status)");
        System.out.println("--- Metadaten ---");
        System.out.println("11 - Skates-Tabelle Metadaten anzeigen");
        System.out.println("12 - Foreign Keys von Ausleihen anzeigen");
        System.out.println("0  - Beenden");
        System.out.print("Auswahl: ");
    }

    private static Ausleihe leseAusleiheDaten() {
        System.out.print("KDNR: ");
        int kdnr = leseInt();

        System.out.print("SkateID: ");
        int skateId = leseInt();

        System.out.print("Ausleihdatum (YYYY-MM-DD): ");
        String ausleihdatum = scanner.nextLine().trim();

        return new Ausleihe(kdnr, skateId, ausleihdatum);
    }

    private static int leseInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Bitte eine gültige Zahl eingeben: ");
            }
        }
    }

    private static void printListe(List<String> liste) {
        if (liste == null || liste.isEmpty()) {
            System.out.println("(keine Einträge gefunden)");
            return;
        }
        for (String eintrag : liste) {
            System.out.println("  " + eintrag);
        }
    }

    private static void printHashMapFloat(HashMap<Float, Integer> map) {
        if (map == null || map.isEmpty()) {
            System.out.println("(keine Einträge gefunden)");
            return;
        }
        for (HashMap.Entry<Float, Integer> entry : map.entrySet()) {
            System.out.println("  Größe " + entry.getKey() + ": " + entry.getValue() + " Ausleihen");
        }
    }

}