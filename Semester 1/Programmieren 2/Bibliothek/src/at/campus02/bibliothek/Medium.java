package at.campus02.bibliothek;

public abstract class Medium implements Comparable<Medium> {
    private String title;
    private int erscheinungsjahr;
    private double preis;


    public Medium(String title, int erscheinungsjahr, double preis) {
        this.title = title;
        this.erscheinungsjahr = erscheinungsjahr;
        this.preis = preis;
    }

    @Override
    public String toString() {
        return String.format("Mediumtyp: %s, Title: %s, Erscheinungsjahr: %d, Preis: €%.2f",
                getMedientyp(), title, erscheinungsjahr, preis);
    }


    // Methode um Mediums nach Erscheinungsjahr zu sortieren
    public int compareTo(Medium anderesMedium) {
        // dieses Medium hat späters Erscheinungsjahr als das andere Medium
        if (this.erscheinungsjahr > anderesMedium.erscheinungsjahr) return 1;
        // dieses Medium hat früheres Erscheinungsjahr als das andere Medium
        if (this.erscheinungsjahr < anderesMedium.erscheinungsjahr) return -1;
            // gleiches Erscheinungsjahr
        else return 0;
    }


    // --- GETTERS

    // das könnte mit folgendes funktionieren ohne die (in diesen fall nicht-abstrakte) Methode in KinderKlassen dann überschreiben zu müssen:
    // return this.getClass().getSimpleName();
    //aber dadurch, dass ich von der Angabe verstehe, dass die getMedienTyp() Methode von Kinderklassen implementiert
    // werden sollte mache ich das so:

    // diese Methode ist abstrakt, damit jede Kindklasse gezwungen ist, sie selbst zu implementieren
    public abstract String getMedientyp();

    public String getTitle() {
        return title;
    }


    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public double getPreis() {
        return preis;
    }

}
