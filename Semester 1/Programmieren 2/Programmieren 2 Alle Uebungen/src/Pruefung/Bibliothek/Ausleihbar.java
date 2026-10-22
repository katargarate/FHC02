package Pruefung.Bibliothek;

public interface Ausleihbar {

    boolean istAusgeliehen();

    void ausleihen(String name);

    void zurueckgeben();

    String getAusleieher();

}
