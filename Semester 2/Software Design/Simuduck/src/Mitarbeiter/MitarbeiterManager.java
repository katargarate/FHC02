package Mitarbeiter;

import java.util.ArrayList;

public class MitarbeiterManager {
    ArrayList<Mitarbeiter> alleMitarbeiter;

    public MitarbeiterManager(ArrayList<Mitarbeiter> alleMitarbeiter) {
        this.alleMitarbeiter = alleMitarbeiter;
    }

    public void provisionenBerechnen() {
       for (Mitarbeiter m : alleMitarbeiter) {
           m.getAusgerechneteProvision();
       }
    }

    public void setProvision (ProvisionBerechnung provisionBerechnung) {
        for (Mitarbeiter mitarbeiter : alleMitarbeiter) {
            mitarbeiter.setProvisionBerechnung(provisionBerechnung);
        }
    }

}
