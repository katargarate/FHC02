package at.campus02.bibliothek;

public class Buch extends Medium implements Ausleihbar{
    private String autor;
    private int seiten;

    private boolean ausgeliehen = false; // auf false initialisieren
    private String ausleiher = null; // auf null initialisieren


    public Buch(String title, int erscheinungsjahr, double preis, String autor, int seiten) {
        super(title, erscheinungsjahr, preis);
        this.autor = autor;
        this.seiten = seiten;
    }

    // abstrakte Methode wird überschrieben, und "Buch" wird somit zurückgegeben
    @Override
    public String getMedientyp() {
        return "Buch";
    }

    @Override
    public String toString() {
        // Zusatz Informationen zu den schon von Medium schon bereitgestellten Informationen zurückgeben
        return super.toString() + String.format(", Autor: %s, Seiten: %d", autor, seiten);
    }


    // -- METHODEN VON Ausleihbar INTERFACE

    @Override
    public void ausleihen(String name) {
        // zuerst überprüfen, ob das Buch schon ausgeliehen ist, wenn nein:
        if (!ausgeliehen) {
            ausgeliehen = true; // boolean marker auf true setzen
            ausleiher = name; // name vom Ausleiher speichern

            System.out.println("\nDas Buch wurde erfolgreich ausgeliehen.");
        }

        else System.out.printf("\nDas Buch ist bereits von %s ausgeliehen.", ausleiher); // sonst: Fehlermeldung
    }

    @Override
    public void zurueckgeben() {
        // zuerst überprüfen, ob das Buch überhaupt ausgeliehen ist, wenn ja:
        if (ausgeliehen) {
            ausgeliehen = false; // boolean marker auf false setzen
            ausleiher = null; // name vom Ausleiher auf null setzen

            System.out.println("\nDas Buch wurde erfolgreich ausgeliehen.");
        }

        else System.out.println("\nDas Buch ist nicht ausgeliehen also kann sie nicht zurückgegeben werden"); // sonst: Fehlermeldung
    }

    @Override
    public boolean istAusgeliehen() {
        return ausgeliehen;
    }


    @Override
    public String getAusleieher() {
        return ausleiher;
    }


}
