package Hasen_Sortierung_Beispiel;

import java.util.Comparator;

public class KarottenComparatorASC implements Comparator<Hase> {
    @Override
    public int compare(Hase o1, Hase o2) {
        if (o1.getAnzahlKarotten() > o2.getAnzahlKarotten()) { // 1 mehr Karotten als 2
            return 1;
        } else if (o1.getAnzahlKarotten() < o2.getAnzahlKarotten()) { // 1 weniger Karotten als 2
            return -1;
        } return 0; // gleich viele
    }
}
