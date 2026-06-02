package Pruefungsuebungen.Pruefung_Musikanten_1;

public abstract class Musikant {

     int anzahlBeine; // package-private default (~ im Klassen Diagramm)
     Instrument instrument;

    public Musikant(int anzahlBeine, Instrument instrument) {
        this.anzahlBeine = anzahlBeine;
        this.instrument = instrument;
    }

    public int getAnzahlBeine() {
        return anzahlBeine;
    }

    public Instrument getInstrument() {
        return instrument;
    }


    abstract int verscheucheRaeuber();


    abstract double spieleMusik();


    public String toString() {
        return String.format("Verscheucht: %d, Musiziert: %.2f", verscheucheRaeuber(), spieleMusik());
    }

}
