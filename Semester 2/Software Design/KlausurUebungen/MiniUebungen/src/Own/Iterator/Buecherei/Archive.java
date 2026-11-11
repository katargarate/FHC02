package Own.Iterator.Buecherei;

import java.util.ArrayList;
import java.util.Iterator;

public class Archive implements Iterable<Book> {
    private final ArrayList<Book> books = new ArrayList<>();

    public void add(Book b) {
        books.add(b);
    }

    @Override
    public Iterator<Book> iterator() {
        // the ArrayList already provides an iterator
        return books.iterator();
    }
}