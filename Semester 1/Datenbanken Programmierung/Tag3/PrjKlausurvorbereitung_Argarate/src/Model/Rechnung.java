package Model;

public class Rechnung {
    private int reNr;
    private String datum;
    private float gesamtbetrag;
    private int kdnr;

    public Rechnung(int reNr, String datum, float gesamtbetrag, int kdnr) {
        this.reNr = reNr;
        this.datum = datum;
        this.gesamtbetrag = gesamtbetrag;
        this.kdnr = kdnr;
    }

    // Überladener Konstruktor ohne reNr, da es automatisch generiert wird
    public Rechnung(String datum, float gesamtbetrag, int kdnr) {
        this.datum = datum;
        this.gesamtbetrag = gesamtbetrag;
        this.kdnr = kdnr;
    }

    // toString-Methode für die Ausgabe der Rechnungsdaten
    public String toString() {
        return String.format("Rechnung %d: Datum: %s, Gesamtbetrag: %.2f, KDNR: %d", reNr, datum, gesamtbetrag, kdnr);
    }

    // GETTER UND SETTER

    public int getReNr() {
        return reNr;
    }

    public void setReNr(int reNr) {
        this.reNr = reNr;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public float getGesamtbetrag() {
        return gesamtbetrag;
    }

    public void setGesamtbetrag(float gesamtbetrag) {
        this.gesamtbetrag = gesamtbetrag;
    }

    public int getKdnr() {
        return kdnr;
    }

    public void setKdnr(int kdnr) {
        this.kdnr = kdnr;
    }
}
