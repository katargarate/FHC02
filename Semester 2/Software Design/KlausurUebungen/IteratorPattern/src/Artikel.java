public class Artikel {
    protected String name;
    protected int anzahl;

    public Artikel(String name, int anzahl) {
        this.name = name;
        this.anzahl = anzahl;
    }

    @Override
    public String toString() {
        return String.format("name: %s, anzahl: %d", name, anzahl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
}
