package Eissalon_Comparator.Main;

import java.util.Comparator;

public class PreisComparatorDESC implements Comparator<Eissorte> {
    @Override
    public int compare(Eissorte eissorte1, Eissorte eissorte2) {
        if (eissorte1.getPreis() > eissorte2.getPreis()) { // 1 teurer als 2
            return -1;
        } else if (eissorte1.getPreis() < eissorte2.getPreis()) { // 1 billiger als 2
            return 1;
        } return 0; // gleich teuer
    }
}
