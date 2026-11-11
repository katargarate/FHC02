import java.util.ArrayList;
import java.util.Iterator;

public class Einkaufstasche implements Iterable<Artikel> {

    private ArrayList<Artikel> alleArtikel = new ArrayList<>();

    @Override
    public Iterator<Artikel> iterator() {
        return new EinkaufstascheIterator(alleArtikel);
    }

    public void addArtikel(Artikel a) {
        if (a.getAnzahl() < 1) {
            System.out.println("Anzahl ist 0, kann nicht hinzugefügt werden.");
            return;
        }
        alleArtikel.add(a);
        System.out.println("Artikel hinzugefügt: " + a.toString());
    }

    public ArrayList<Artikel> getAlleArtikel() {
        return alleArtikel;
    }
}
