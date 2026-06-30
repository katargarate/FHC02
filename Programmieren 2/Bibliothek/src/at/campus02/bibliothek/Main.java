package at.campus02.bibliothek;

import at.campus02.bibliothek.Comparators.PreisComparator;
import at.campus02.bibliothek.Comparators.TitelComparator;
import at.campus02.bibliothek.Comparators.TypComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static void main(String[] args) {

        // -- BUCH TESTEN
        System.out.println("\n-------- BUCH TESTS ----------\n");
        Buch b1 = new Buch("Der Herr der Ringe", 1954, 19.54, "J.R.R. Tolkien", 400);
        System.out.println(b1); // to string ausgeben
        System.out.println("Medientyp: " + b1.getMedientyp()); // medientyp ausgeben

        // - ausleihen testen
        b1.ausleihen("Max Mustermann"); // buch ausleihen
        System.out.println("\nIst das Buch ausgeliehen? " + b1.istAusgeliehen()); // überprüfen, ob das Buch ausgeliehen ist
        b1.ausleihen("Maria Musterfrau"); // versuchen, das Buch nochmal auszuleihen (sollte Fehlermeldung ausgeben)

        // - zurückgeben testen
        b1.zurueckgeben(); // Buch zurückgeben
        b1.zurueckgeben(); // versuchen, das Buch nochmal zurückzugeben (sollte Fehlermeldung ausgeben)


        // -- FILM TESTEN
        System.out.println("\n-------- FILM TESTS ----------\n");
        Film f1 = new Film("The Room", 2003, 9.99, "Tommy Wiseau", 99);
        System.out.println(f1); // toString ausgeben

        // bewertung testen
        f1.setBewertung(0); // ungültige Bewertung setzen (sollte Fehlermeldung ausgeben)
        System.out.println("Bewertung: " + f1.getBewertung());

        f1.setBewertung(5); // gültige Bewertung setzen
        System.out.println("Bewertung: " + f1.getBewertung());



        // -- HOERBUCH TESTEN
        System.out.println("\n-------- HOERBUCH TESTS ----------\n");
        Hoerbuch h1 = new Hoerbuch("Harry Potter und der Stein der Weisen", 1997, 29.99, "J.K. Rowling", 480);
        System.out.println(h1); // toString ausgeben


        // -- SORTIERUNG TESTEN
        System.out.println("\n-------- SORTIERUNG TESTS ----------\n");
        ArrayList<Medium> alleMedien = new ArrayList<>(); // kann alle Arten von Medien erhalten (Buch, Hperbuch, Film)

        alleMedien.add(b1);
        alleMedien.add(f1);
        alleMedien.add(h1);

        // -- Medien zuerst mit comparable sortieren (Nach
        Collections.sort(alleMedien);
        System.out.println("Medien sortiert nach Erscheinungsjahr(");
        for (Medium m : alleMedien) {
            // nur Erscheinungsjahr und Title für Überblick
            System.out.printf("%d - %s\n", m.getErscheinungsjahr(), m.getTitle());
        }


        // -- Medien mit PreisComparator sortiert
        PreisComparator preisComparator = new PreisComparator();
        alleMedien.sort(preisComparator);
        System.out.println("\nMedien sortiert nach Preis:");

        for (Medium m : alleMedien) {
            System.out.printf("€%.2f - %s\n", m.getPreis(), m.getTitle());
        }


        // -- Medien mit TitelComparator sortiert
        TitelComparator titelComparator = new TitelComparator();
        alleMedien.sort(titelComparator);

        System.out.println("\nMedien sortiert nach Titel:");
        for (Medium m : alleMedien) {
            System.out.println(m.getTitle());
        }


        // -- Medien mit TypComparator sortiert
        TypComparator typComparator = new TypComparator();
        alleMedien.sort(typComparator);

        System.out.println("\nMedien sortiert nach Typ:");
        for (Medium m : alleMedien) {
            System.out.printf("%s: %s\n", m.getMedientyp(),m.getTitle());
        }


        // -- BIBLIOTHEK TESTEN

        Bibliothek bib = new  Bibliothek();
        bib.addMedium(b1);
        bib.addMedium(f1);
        bib.addMedium(h1);

        // extra bücher erstellt
        Buch b2 = new Buch("Anderes Buch", 2020, 12.99, "Willi Thaler", 200);
        Buch b3 = new Buch("Noch einen Buch", 2000, 13.99, "HalliiHallo Thaler", 250);
        bib.addMedium(b2);
        bib.addMedium(b3);


        // -- sortieren nach Jahr testen
        bib.printNachJahr();

        // -- sortieren nach Preis testen
        bib.printNachPreis();

        // -- verfuegbare Bücher Testen
        b3.ausleihen("Sarah Snowman"); // ausleihen
        bib.printVerfuegbareBuecher(); // "Noch Einen Buch" soll nicht erscheinen


        // NEIN, DAS AUSGELIEHENE BUCH "Noch Einen Buch" IST NICHT DABEI

        // BONUS: getMedienTyp() funktioniert bei ArrayList mit alle 3 Medientypen:
        System.out.println("\n-------- BONUS ----------\n");

        for (Medium m : bib.getMedien()) {
            System.out.println(m);
        }

    }
}
