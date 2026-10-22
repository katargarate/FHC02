package Pruefung.Bibliothek;

public class Film extends Medium{
    private String regisseur;
    private int laengeMinuten;

    private int bewertung = 0; // bei null initialisieren, da noch keine Bewertungen gemacht wurden


    public Film(String title, int erscheinungsjahr, double preis, String regisseur, int laengeMinuten) {
        super(title, erscheinungsjahr, preis);
        this.regisseur = regisseur;
        this.laengeMinuten = laengeMinuten;
    }

    public void setBewertung(int sterne) {
        if (sterne < 1 || sterne > 5) {
            // Fehlermeldung, wenn sterne nciht zwischen 1-5 liegt
            System.out.println("Ungültige Bewertung. Sterneanzahl muss zwischen 1 und 5 ein liegen.");
        } else {
            this.bewertung = sterne; // setzt die Bewertung an ert von Sterne

            // (evtl. wäre ein Durchschnitt aus mehreren Bewertungen sinnvoller,
            // aber hier wird nur die letzte Bewertung gespeichert, da wir keine andere Daten haben)
        }
    }

    @Override
    public String getMedientyp() {
        return "Film";
    }

    @Override
    public String toString() {
        // wenn Bewertung noch bei 0 (Initialisionswert) ist, folgendes augsgeben:
        if (bewertung == 0) {
            return super.toString() +
                    String.format(", Regisseur: %s, Länge: %d Minuten, Bewertung: Noch keine Bewertung", regisseur, laengeMinuten);
        }

        // sonst:
        return super.toString() +
                String.format(", Regisseur: %s, Länge: %d Minuten, Bewertung: %s Sterne", regisseur, laengeMinuten, bewertung);
    }




    // -- GETTERS

    public String getRegisseur() {
        return regisseur;
    }

    public int getLaengeMinuten() {
        return laengeMinuten;
    }

    public int getBewertung() {
        return bewertung;
    }
}
