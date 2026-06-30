package at.campus02.bibliothek.Comparators;

import at.campus02.bibliothek.Medium;

import java.util.Comparator;

public class TypComparator implements Comparator<Medium> {

    @Override
    public int compare(Medium m1, Medium m2) {
        // vergleicht die Typ (String) und gibt einen negativen Wert zurück,
        // wenn m1 vor m2 kommt, einen positiven Wert,
        // wenn m1 nach m2 kommt, und 0, wenn sie gleich sind
        return m1.getMedientyp().compareTo(m2.getMedientyp());
    }
}