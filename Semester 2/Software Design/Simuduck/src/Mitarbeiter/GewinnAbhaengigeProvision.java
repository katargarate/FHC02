package Mitarbeiter;

public class GewinnAbhaengigeProvision implements ProvisionBerechnung {


    @Override
    public void provisionBerechnen(Mitarbeiter mitarbeiter) {
        System.out.printf("\n%s Provision (10 Prozent des Gewinnes €%.2f) : €%.2f", mitarbeiter.getName(), mitarbeiter.getGewinn(),  mitarbeiter.getGewinn() * 0.1);

    }
}
