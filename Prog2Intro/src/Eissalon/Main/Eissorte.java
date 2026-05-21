package Eissalon.Main;

public class Eissorte implements Comparable<Eissorte> {
    private String name;
    private double preis;

    public Eissorte(String name, double preis) {
        this.name = name;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return String.format("€ %.2f - %s", preis, name);
    }

    @Override
    public int compareTo(Eissorte andereSorte) {
        if  (this.preis > andereSorte.preis) return 1;
        else if (this.preis < andereSorte.preis) return -1;
        else return 0;
    }
}
