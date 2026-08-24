package Model;

public class Kunde {
    private Integer kdnr;
    private String vorname;
    private String nachname;
    private String geschlecht;
    private Integer bonuspunkte;

    public Kunde(Integer kdnr, String vorname, String nachname, String geschlecht, Integer bonuspunkte) {
        this.kdnr = kdnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.bonuspunkte = bonuspunkte;
    }

    // Überladener Konstruktor ohne kdnr, da es automatisch generiert wird
    public Kunde(String vorname, String nachname, String geschlecht, int bonuspunkte) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.bonuspunkte = bonuspunkte;
    }

    // toString-Methode für die Ausgabe der Kundendaten
    public String toString() {
        return String.format("Kunde %d: %s %s, Geschlecht: %s, Bonuspunkte: %d", kdnr, vorname, nachname, geschlecht, bonuspunkte);
    }

    // GETTER UND SETTER

    public Integer getKdnr() {
        return kdnr;
    }

    public void setKdnr(Integer kdnr) {
        this.kdnr = kdnr;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public Integer getBonuspunkte() {
        return bonuspunkte;
    }

    public void setBonuspunkte(Integer bonuspunkte) {
        this.bonuspunkte = bonuspunkte;
    }
}
