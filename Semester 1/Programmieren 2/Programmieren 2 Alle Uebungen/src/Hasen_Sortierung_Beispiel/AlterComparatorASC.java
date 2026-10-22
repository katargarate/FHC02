package Hasen_Sortierung_Beispiel;

import java.util.Comparator;

public class AlterComparatorASC implements Comparator<Hase> {
    @Override
    public int compare(Hase o1, Hase o2) {
        if (o1.getAlter() > o2.getAlter()) {
            return 1;
        } else if (o1.getAlter() < o2.getAlter()) {
            return -1;
        } return 0;
    }
}
