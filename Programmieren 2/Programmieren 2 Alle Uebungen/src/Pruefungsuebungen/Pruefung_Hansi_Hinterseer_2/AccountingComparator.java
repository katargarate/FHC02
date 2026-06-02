package Pruefungsuebungen.Pruefung_Hansi_Hinterseer_2;

import java.util.Comparator;

public class AccountingComparator implements Comparator<NFCTicket> {

    @Override
    public int compare(NFCTicket t1, NFCTicket t2) {
        if (t1.getCategory() < t2.getCategory()) { // 1 niedriger Kategorie als 2
            return -1;
        } else if (t1.getCategory() > t2.getCategory()) { // 1 höhere Kategorie als 2
            return 1;
        } else {  // bei gleiche Kategorie, alphabetisch sortieren
            return t1.toString().compareTo(t2.toString());
        }
    }
}
