package Models;

public class Katze {
    private String name;
    private int alter;
    private String rasse;

    public Katze(String name, int alter, String rasse) {
        this.name = name;
        this.alter = alter;
        this.rasse = rasse;
    }

    public void knurren() {
        System.out.println("knurr");
    }

    public void hundWeglaufen(Hund hund) {
        if (hund.getName().equals("Foxi")) System.out.println("Alles gut, das ist mein Freund");
        else System.out.println("Kenne ich nicht, weglaufen!");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getRasse() {
        return rasse;
    }

    public void setRasse(String rasse) {
        this.rasse = rasse;
    }
}
