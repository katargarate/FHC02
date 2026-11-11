package Own.Iterator.Buecherei;

import java.util.Iterator;

public class Bookshelf implements Iterable<Book> {
    protected Book[] books;

    public Bookshelf(Book[] books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new ReverseIterator<Book>(books);
    }
}
