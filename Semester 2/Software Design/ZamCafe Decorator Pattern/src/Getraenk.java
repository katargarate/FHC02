public abstract class Getraenk {
    private String beschreibung;

    public abstract double kostet();

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
