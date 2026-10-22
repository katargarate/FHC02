package Pruefung.Bibliothek;

public class Hoerbuch extends Medium{
    private String sprecher;
    private int dauerMinuten;

    public Hoerbuch(String title, int erscheinungsjahr, double preis, String sprecher, int dauerMinuten) {
        super(title, erscheinungsjahr, preis);
        this.sprecher = sprecher;
        this.dauerMinuten = dauerMinuten;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Sprecher: %s, Dauer: %d Minuten", sprecher, dauerMinuten);
    }

    @Override
    public String getMedientyp() {
        return "Hoerbuch";
    }


    // -- GETTERS


    public String getSprecher() {
        return sprecher;
    }

    public int getDauerMinuten() {
        return dauerMinuten;
    }
}
