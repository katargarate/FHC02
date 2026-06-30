package at.campus02.bibliothek;

import at.campus02.bibliothek.Comparators.PreisComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Bibliothek {
    private ArrayList<Medium> medien;

    public Bibliothek() {
        medien = new ArrayList<>(); // initialisieren
    }


    public void addMedium(Medium m) {
        medien.add(m);
    }

    public void printNachJahr() {
        Collections.sort(medien); //inplace Sortierung mit compareTo Klasse von Medium
        System.out.println("\nMedien sortiert nach Erscheinungsjahr:");

        for (Medium m : medien) {
            System.out.println(m);
        }
    }

    public void printNachPreis() {
        PreisComparator preisComparator = new PreisComparator();
        medien.sort(preisComparator); //inplace Sortierung mit preisComparator

        // sortierte Medien ausgeben
        for (Medium m : medien) {
            System.out.println(m); // passende toStrings werden ausgegeben
        }
    }

    public void printVerfuegbareBuecher() {
        ArrayList<Buch> verfuegbareBuecher = new ArrayList<>();

        // alle medien durchschleifen
        for (Medium m : medien) {
            // nur wenn das aktuelle Medium ein Buch ist, soll es in die Liste der verfügbaren Bücher aufgenommen werden
            if (m instanceof Buch && !((Buch) m).istAusgeliehen()) {
                verfuegbareBuecher.add((Buch) m);
            }
        }

        // die verfügbaren Bücher alle ausgeben
        System.out.println("\nVerfügbare Bücher:");
        for (Buch b : verfuegbareBuecher) {
            System.out.println(b);
        }
    }

    public ArrayList<Medium> getMedien() {
        return medien;
    }
}
