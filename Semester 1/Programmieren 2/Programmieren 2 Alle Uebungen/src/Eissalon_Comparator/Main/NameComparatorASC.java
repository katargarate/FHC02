package Eissalon_Comparator.Main;

import java.util.Comparator;

public class NameComparatorASC implements Comparator<Eissorte> {

    @Override
    public int compare(Eissorte eissorte1, Eissorte eissorte2) {
        return eissorte1.toString().compareTo(eissorte2.toString());
    }
}

