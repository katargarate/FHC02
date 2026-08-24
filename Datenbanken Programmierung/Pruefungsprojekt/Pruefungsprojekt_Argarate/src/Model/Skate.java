package Model;

public class Skate {
    private Integer skateId;
    private float groesse;
    private String marke;
    private String modell;
    private boolean verfuegbar;

    public Skate(Integer skateId, float groesse, String marke, String modell, boolean verfuegbar) {
        this.skateId = skateId;
        this.groesse = groesse;
        this.marke = marke;
        this.modell = modell;
        this.verfuegbar = verfuegbar;
    }

    public Skate(float groesse, String marke, String modell) {
        this.groesse = groesse;
        this.marke = marke;
        this.modell = modell;
        this.verfuegbar = true; // neu angelegte Skates sind standardmäßig verfügbar
    }

    public String toString() {
        return String.format("Skate %d: Größe %.1f, %s %s, Verfügbar: %b",
                skateId, groesse, marke, modell, verfuegbar);
    }

    public Integer getSkateId() { return skateId; }
    public void setSkateId(Integer skateId) { this.skateId = skateId; }
    public float getGroesse() { return groesse; }
    public void setGroesse(float groesse) { this.groesse = groesse; }
    public String getMarke() { return marke; }
    public void setMarke(String marke) { this.marke = marke; }
    public String getModell() { return modell; }
    public void setModell(String modell) { this.modell = modell; }
    public boolean isVerfuegbar() { return verfuegbar; }
    public void setVerfuegbar(boolean verfuegbar) { this.verfuegbar = verfuegbar; }
}