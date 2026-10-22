package Model;

public class Kunde {
    private Integer kdnr;
    private String vorname;
    private String nachname;
    private String email;
    private String telefon;

    public Kunde(Integer kdnr, String vorname, String nachname, String email, String telefon) {
        this.kdnr = kdnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.telefon = telefon;
    }

    public Kunde(String vorname, String nachname, String email, String telefon) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.telefon = telefon;
    }

    public String toString() {
        return String.format("Kunde %d: %s %s, Email: %s, Telefon: %s", kdnr, vorname, nachname, email, telefon);
    }

    public Integer getKdnr() { return kdnr; }
    public void setKdnr(Integer kdnr) { this.kdnr = kdnr; }
    public String getVorname() { return vorname; }
    public void setVorname(String vorname) { this.vorname = vorname; }
    public String getNachname() { return nachname; }
    public void setNachname(String nachname) { this.nachname = nachname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }
}