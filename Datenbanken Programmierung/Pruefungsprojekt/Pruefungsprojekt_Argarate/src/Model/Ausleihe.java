package Model;

public class Ausleihe {
    private Integer ausleihId;
    private int kdnr;
    private int skateId;
    private String ausleihdatum;
    private String rueckgabedatum; // null, solange der Skate noch nicht zurückgegeben wurde

    public Ausleihe(Integer ausleihId, int kdnr, int skateId, String ausleihdatum, String rueckgabedatum) {
        this.ausleihId = ausleihId;
        this.kdnr = kdnr;
        this.skateId = skateId;
        this.ausleihdatum = ausleihdatum;
        this.rueckgabedatum = rueckgabedatum;
    }

    // Überladener Konstruktor für eine neue Ausleihe (noch keine Rückgabe)
    public Ausleihe(int kdnr, int skateId, String ausleihdatum) {
        this.kdnr = kdnr;
        this.skateId = skateId;
        this.ausleihdatum = ausleihdatum;
        this.rueckgabedatum = null;
    }

    public String toString() {
        return String.format("Ausleihe %d: KDNR %d, SkateID %d, Ausleihdatum: %s, Rückgabedatum: %s",
                ausleihId, kdnr, skateId, ausleihdatum,
                rueckgabedatum == null ? "noch nicht zurückgegeben" : rueckgabedatum);
    }

    public Integer getAusleihId() { return ausleihId; }
    public void setAusleihId(Integer ausleihId) { this.ausleihId = ausleihId; }
    public int getKdnr() { return kdnr; }
    public void setKdnr(int kdnr) { this.kdnr = kdnr; }
    public int getSkateId() { return skateId; }
    public void setSkateId(int skateId) { this.skateId = skateId; }
    public String getAusleihdatum() { return ausleihdatum; }
    public void setAusleihdatum(String ausleihdatum) { this.ausleihdatum = ausleihdatum; }
    public String getRueckgabedatum() { return rueckgabedatum; }
    public void setRueckgabedatum(String rueckgabedatum) { this.rueckgabedatum = rueckgabedatum; }
}