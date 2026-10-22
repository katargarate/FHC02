package Models;

public class Teilnehmer {
    private String name;
    private int alter;
    private String adresse;
    private int counter;

    public Teilnehmer(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    public void hatFrageGestellt() {
        counter++;
    }

    // funktioniert eigenltich genau sowie ein Getter
    public int rueckgabeFragenCounter() {
        return counter;
    }

    public void teilnehmerInfo() {
        System.out.printf("""
                Name: %s
                Alter: %d
                Adresse: %s
                Fragen Counter: %s
                """, name, alter, adresse, counter);
    }


    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
