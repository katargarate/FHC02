package klatsch.krone.at;

public interface Abonnent {

    //wenn Medienverlag einen neuen Artikel heraus bringt
    public void erhalte(Artikel artikel);
    public String getName();
}
