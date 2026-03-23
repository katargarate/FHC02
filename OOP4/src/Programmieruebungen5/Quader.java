package Programmieruebungen5;


public class Quader {
    private double laenge;
    private double breite;
    private double hoehe;
    private double grundflaeche;
    private double oberflaeche;
    private double volumen;

    public Quader(double laenge, double breite, double hoehe) {
        this.laenge = laenge;
        this.breite = breite;
        this.hoehe = hoehe;

        grundflaeche();
        this.volumen = volumen();
        this.oberflaeche = oberflaeche();
    }

    private double grundflaeche() {
        return laenge * breite;
    }

    public void skaliere(double faktor) {
        laenge *= faktor;
        breite *= faktor;
        hoehe *= faktor;
    }

    private double volumen(){
        return laenge * breite * hoehe;
    }

    private double oberflaeche(){
        return 2*(laenge*breite) + 2*(laenge*hoehe) + 2*(breite*hoehe);
    }

    public void displayInfo() {

        System.out.printf("""
                
                Länge: %.1f
                Breite: %.1f
                Höhe: %.1f
                
                Grundfläche: %.1f
                Volumen: %.1f
                Oberfläche: %.1f
                """, laenge, breite, hoehe, grundflaeche(), volumen(), oberflaeche());
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getGrundflaeche() {
        return grundflaeche;
    }

    public void setGrundflaeche(double grundflaeche) {
        this.grundflaeche = grundflaeche;
    }

    public double getOberflaeche() {
        return oberflaeche;
    }

    public void setOberflaeche(double oberflaeche) {
        this.oberflaeche = oberflaeche;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
}
