import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EinkaufstascheIterator implements Iterator {
    private ArrayList<Artikel> alleArtikel = new ArrayList<>();
    private int currPos;

    public EinkaufstascheIterator(ArrayList<Artikel> alleArtikel) {
        this.alleArtikel = alleArtikel;
        currPos = 0;
    }

    @Override
    public boolean hasNext() {
        System.out.println("HASNEXT AUFGERUFEN");
        return (alleArtikel.size() > currPos);
    }
    @Override
    public Artikel next() {
        System.out.println("NEXT AUFGERUFEN");
        if (! this.hasNext())
        {
            throw new NoSuchElementException();
        }
        Artikel ret = alleArtikel.get(currPos);
        currPos++;
        return ret;
    }
}
