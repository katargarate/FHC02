package Programmieruebungen5;

public class Rezept {
    private int anzahlPersonen;
    private String[] zutatenName; // Namen der Zutaten
    private double[][] zutaten;   // [Menge, Preis]

    public Rezept(int anzahlPersonen, String[] zutatenName, double[][] zutaten) {
        this.anzahlPersonen = anzahlPersonen;
        this.zutatenName = zutatenName;
        this.zutaten = zutaten;
    }

    public boolean allergisch(String zutat) {
        zutat = zutat.toLowerCase();

        for (String item : zutatenName) {
            if (item.toLowerCase().equals(zutat)) {
                return true;
            }
        }
         return false;
    }

    public double kostet() {
        double summe = 0;

        for (int i = 0; i < zutaten.length; i++) {
            summe += zutaten[i][1]; // Preis
        }

        return summe;
    }

    public double kostetProPerson() {
        return kostet() / anzahlPersonen;
    }

    public void aenderePersonen(int anzahl) {
        if (anzahl <= 0) {
            return; // nichts ändern
        }

        double faktor = (double) anzahl / this.anzahlPersonen;

        for (int i = 0; i < zutaten.length; i++) {
            zutaten[i][0] *= faktor; // Menge
            zutaten[i][1] *= faktor; // Preis
        }

        this.anzahlPersonen = anzahl;
    }

    public boolean laktoseFrei() {
        boolean wurdeGeaendert = false;

        for (int i = 0; i < zutatenName.length; i++) {

            String name = zutatenName[i].toLowerCase();

            if (name.contains("milch") || name.contains("käse")) {
                zutaten[i][0] = 0; // Menge
                zutaten[i][1] = 0; // Preis
                wurdeGeaendert = true;
            }
        }

        return wurdeGeaendert;
    }

    // Getter & Setter

    public int getAnzahlPersonen() {
        return anzahlPersonen;
    }

    public void setAnzahlPersonen(int anzahlPersonen) {
        aenderePersonen(anzahlPersonen);
    }

}