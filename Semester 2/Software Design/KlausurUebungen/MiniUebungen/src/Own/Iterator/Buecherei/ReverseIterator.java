package Own.Iterator.Buecherei;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseIterator<T> implements Iterator<Book> {
    protected int pos;
    protected Book[] books;

    public ReverseIterator(Book[] books) {
        this.books = books;
        pos = books.length - 1;
    }

    @Override
    public boolean hasNext() {
        // walking backwards, so we're done when pos drops below 0
        return pos >= 0;
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return books[pos--];
    }
}
