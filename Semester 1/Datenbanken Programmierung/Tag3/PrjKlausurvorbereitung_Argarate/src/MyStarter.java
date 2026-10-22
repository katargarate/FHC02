import Controller.DBHelper;
import Model.Kunde;
import Model.Rechnung;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MyStarter {
    private static final DBHelper dbHelper = new DBHelper();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        dbHelper.openConnection();

        // Setup: Tabellen erstellen und mit Testdaten befüllen -
        // passiert automatisch, damit alle Menüoptionen sofort funktionieren
        dbHelper.createKundenTable();
        dbHelper.createRechnungenTable();
        dbHelper.fillTablesWithDummyData();
        System.out.println("Tabellen wurden erstellt und mit Testdaten befüllt.\n");

        boolean beenden = false;
        while (!beenden) {
            zeigeMenue();
            String eingabe = scanner.nextLine().trim();

            switch (eingabe) {
                case "1" -> {
                    System.out.println("\nAlle Kunden:");
                    printKunden(dbHelper.getAlleKunden());
                }
                case "2" -> {
                    System.out.print("\nKDNR eingeben: ");
                    int kdnr = leseInt();
                    Kunde kunde = dbHelper.getKunde(kdnr);
                    // falls der Kunde nicht gefunden wurde, Fehler ausgeben
                    if (kunde == null) System.out.println("Kunde nicht gefunden.");
                    else System.out.println(kunde);
                }
                case "3" -> {
                    System.out.println("\nWeibliche Kunden:");
                    printKunden(dbHelper.getWeiblicheKunden());
                }
                case "4" -> {
                    Kunde neuerKunde = leseKundenDaten();
                    int neueKdnr = dbHelper.insertKunde(neuerKunde);
                    if (neueKdnr !=1) System.out.println("Kunde wurde eingefügt mit KDNR: " + neueKdnr);
                    else System.out.println("Fehler beim Einfügen.");
                }
                case "5" -> {
                    System.out.print("\nKDNR des zu aktualisierenden Kunden: ");
                    int kdnr = leseInt();
                    Kunde bestehenderKunde = dbHelper.getKunde(kdnr);
                    if (bestehenderKunde == null) {
                        System.out.println("Kunde nicht gefunden.");
                    } else {
                        Kunde aktualisierteDaten = leseKundenDaten();
                        aktualisierteDaten.setKdnr(kdnr);
                        dbHelper.updateKunde(aktualisierteDaten);
                    }
                }
                case "6" -> {
                    System.out.print("\nKDNR eingeben: ");
                    int kdnr = leseInt();
                    System.out.println("Rechnungen für Kunde " + kdnr + ":");
                    printRechnungen(dbHelper.getRechnungenByKunde(kdnr));
                }
                case "7" -> {
                    System.out.println("\nKunde mit den meisten Bonuspunkten:");
                    System.out.println(dbHelper.getKundeMitDenMeistenBonusPunkten());
                }
                case "8" -> {
                    System.out.println("\nDurchschnittliche Bonuspunkte pro Geschlecht:");
                    printHashMap(dbHelper.getDurchschnittlicheBonuspunkteProGeschlecht());
                }
                case "9" -> {
                    System.out.println("\nUmsatz gruppiert nach Geschlecht:");
                    printHashMap(dbHelper.getUmsatzGruppiertNachGeschlecht());
                }
                case "10" -> {
                    System.out.print("\nKDNR des zu löschenden Kunden: ");
                    int kdnr = leseInt();
                    Kunde kunde = dbHelper.getKunde(kdnr);
                    if (kunde == null) {
                        System.out.println("Kunde nicht gefunden.");
                    } else {
                        dbHelper.loescheAlleRechnungenUndDanachDenKunden(kunde);
                    }
                }
                case "11" -> dbHelper.printKundenMetadata();
                case "12" -> dbHelper.printTableNames();
                case "0" -> {
                    beenden = true;
                    dbHelper.resetAndCloseConnection();
                    System.out.println("Programm wird beendet.");
                }
                default -> System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
            }

            System.out.println(); // Leerzeile zur besseren Lesbarkeit zwischen Menü-Durchläufen
        }
    }

    private static void zeigeMenue() {
        System.out.println("===== Navigationsmenü =====");
        System.out.println("1  - Alle Kunden anzeigen");
        System.out.println("2  - Einzelnen Kunden anzeigen (per KDNR)");
        System.out.println("3  - Weibliche Kunden anzeigen");
        System.out.println("4  - Neuen Kunden anlegen");
        System.out.println("5  - Kunden aktualisieren");
        System.out.println("6  - Rechnungen eines Kunden anzeigen");
        System.out.println("7  - Kunde mit den meisten Bonuspunkten anzeigen");
        System.out.println("8  - Durchschnittliche Bonuspunkte pro Geschlecht anzeigen");
        System.out.println("9  - Umsatz gruppiert nach Geschlecht anzeigen");
        System.out.println("10 - Kunde + Rechnungen löschen");
        System.out.println("11 - Kunden-Metadaten anzeigen");
        System.out.println("12 - Tabellennamen anzeigen");
        System.out.println("0  - Tabellen löschen und beenden");
        System.out.print("Auswahl: ");
    }

    private static Kunde leseKundenDaten() {
        System.out.print("Vorname: ");
        String vorname = scanner.nextLine().trim();

        System.out.print("Nachname: ");
        String nachname = scanner.nextLine().trim();

        System.out.print("Geschlecht (Mann/Frau/Divers, leer für unbekannt): ");
        String geschlecht = scanner.nextLine().trim();
        if (geschlecht.isEmpty()) geschlecht = null;

        System.out.print("Bonuspunkte: ");
        int bonuspunkte = leseInt();

        return new Kunde(null, vorname, nachname, geschlecht, bonuspunkte);
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

    private static void printKunden(List<Kunde> kunden) {
        if (kunden == null || kunden.isEmpty()) {
            System.out.println("(keine Kunden gefunden)");
            return;
        }
        for (Kunde k : kunden) {
            System.out.println(k);
        }
    }

    private static void printRechnungen(List<Rechnung> rechnungen) {
        if (rechnungen == null || rechnungen.isEmpty()) {
            System.out.println("(keine Rechnungen gefunden)");
            return;
        }
        for (Rechnung r : rechnungen) {
            System.out.println(r);
        }
    }

    private static void printHashMap(HashMap<String, Float> map) {
        for (HashMap.Entry<String, Float> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}