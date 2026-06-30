package at.campus02.bibliothek.Comparators;

import at.campus02.bibliothek.Medium;

import java.util.Comparator;

public class PreisComparator implements Comparator<Medium> {

    @Override
    public int compare(Medium m1, Medium m2) {
        if (m1.getPreis() < m2.getPreis()) {
            return -1; // m1 billiger als m2
        } else if (m1.getPreis() > m2.getPreis()) {
            return 1; // m1 teurer als m2
        } else {
            return 0; // m1 und m2 haben den gleichen Preis
        }
    }
}
