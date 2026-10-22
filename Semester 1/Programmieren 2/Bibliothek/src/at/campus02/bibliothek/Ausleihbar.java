package at.campus02.bibliothek;

public interface Ausleihbar {

    boolean istAusgeliehen();

    void ausleihen(String name);

    void zurueckgeben();

    String getAusleieher();

}
