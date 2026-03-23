package Programmieruebungen5;


public class Auto {
    private String marke;
    private String modell;
    private int jahr;
    private double geschwindigkeit;

    public Auto(String marke, String modell, int jahr) {
        this.marke = marke;
        this.modell = modell;
        this.jahr = jahr;
    }

    public void gasGeben(double geschw) {
        geschwindigkeit += geschw;
    }

     public void bremsen(double geschw) {
        geschwindigkeit -= geschw;
        if (geschwindigkeit < 0 ) geschwindigkeit = 0; // min auf 0
    }

    public String toString() {
        return String.format("""
                Marke: %s
                Modell: %s
                Jahr: %d
                Geschwindigkeit: %.2f
                """, marke, modell, jahr, geschwindigkeit);
    }



    // GETTERS & SETTERS

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }
}
