package Eissalon.Main;

import java.util.*;

public class EissorteManager {

    private List<Eissorte> eissorten;

    public EissorteManager() {
        eissorten = new ArrayList<Eissorte>(); // Array List initialisieren
    }

    public void eissorteHinzufuegen(Eissorte eissorte) {
        eissorten.add(eissorte);
    }

    public List<Eissorte> getEissorten() {
        return eissorten;
    }

    public List<Eissorte> getEissortenSortiertNachPreis(boolean aufsteigend) {
        if (aufsteigend) {
            eissorten.sort(new PreisComparatorASC());
        } else eissorten.sort(new PreisComparatorDESC());

        return eissorten;
    }

    public List<Eissorte> getEissortenSortiertNachName() {
        eissorten.sort(new PreisComparatorASC());
        return eissorten;
    }





}
