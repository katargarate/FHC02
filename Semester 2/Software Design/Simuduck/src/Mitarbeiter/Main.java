package Mitarbeiter;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        Mitarbeiter m1 = new Mitarbeiter("STINKY magda", 230.00, 1200, new GewinnAbhaengigeProvision());
        Mitarbeiter m2 = new Mitarbeiter("Extra stinky Magda", 243.00, 13210.00, new UmsatzAbhaengigeProvision());
        ArrayList<Mitarbeiter> alleMitarbeiter = new ArrayList<Mitarbeiter>();

        alleMitarbeiter.add(m1);
        alleMitarbeiter.add(m2);

        MitarbeiterManager manager = new MitarbeiterManager(alleMitarbeiter);

        System.out.println(m1);
        m1.getAusgerechneteProvision();

        System.out.println("\n\n--- Provisionsart auf Umsatzabhängige Provision ändern: ");
        manager.setProvision(new UmsatzAbhaengigeProvision());
        m1.getAusgerechneteProvision();


    }
}
