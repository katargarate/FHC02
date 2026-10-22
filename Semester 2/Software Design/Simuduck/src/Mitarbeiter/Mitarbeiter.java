package Mitarbeiter;

public class Mitarbeiter {
    private String name;
    private double umsatz;
    private double gewinn;
    private ProvisionBerechnung provisionBerechnung;

    public Mitarbeiter(String name, double umsatz, double gewinn, ProvisionBerechnung provisionBerechnung) {
        this.name = name;
        this.umsatz = umsatz;
        this.gewinn = gewinn;
        this.provisionBerechnung = provisionBerechnung;
    }

    public void getAusgerechneteProvision() {
        provisionBerechnung.provisionBerechnen(this);
    }

    @Override
    public String toString() {
        return String.format("Mitarbeiter - Name: %s, Gewinn: €%.2f, Umsatz: €%.2f, Provisionsart: %s", name, gewinn, umsatz, provisionBerechnung.getClass().getSimpleName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUmsatz() {
        return umsatz;
    }

    public void setUmsatz(double umsatz) {
        this.umsatz = umsatz;
    }

    public double getGewinn() {
        return gewinn;
    }

    public void setGewinn(double gewinn) {
        this.gewinn = gewinn;
    }

    public ProvisionBerechnung getProvisionBerechnung() {
        return provisionBerechnung;
    }

    public void setProvisionBerechnung(ProvisionBerechnung provisionBerechnung) {
        this.provisionBerechnung = provisionBerechnung;
    }
}
