package Mitarbeiter;

public class UmsatzAbhaengigeProvision implements ProvisionBerechnung {


    @Override
    public void provisionBerechnen(Mitarbeiter mitarbeiter) {
        System.out.printf("\n%s Provision (5 Prozent des Umsatzes €%.2f) : €%.2f",
                mitarbeiter.getName(), mitarbeiter.getUmsatz(), mitarbeiter.getUmsatz() * 0.05);
    }
}
