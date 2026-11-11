package Own.Iterator.Buecherei;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Book b1 = new Book("Pride and Prejudice", 1813);
        Book b2 = new Book("Frankenstein", 1818);
        Book b3 = new Book("Moby Dick", 1851);
        Book b4 = new Book("A Tale of Two Cities", 1859);
        Book b5 = new Book("Crime and Punishment", 1866);

        Book[] booksArray = {b1,b2,b3,b4,b5};

        Archive archive = new Archive();
        archive.add(b1);
        archive.add(b2);
        archive.add(b3);
        archive.add(b4);
        archive.add(b5);

        Bookshelf bookshelf = new Bookshelf(booksArray);

        Iterator<Book> bookshelfIterator = bookshelf.iterator();
        Iterator<Book> archiveIterator = archive.iterator();

        System.out.println("--- Bookshelf Own.Iterator(Array) ----");
        printAll(bookshelfIterator);
        System.out.println("Count of book pre-1855: " + countBefore(bookshelf.iterator(), 1855));

        System.out.println("\n\n--- Archive Own.Iterator(ArrayList) ----");
        printAll(archiveIterator);
        System.out.println("Count of book pre-1855: " + countBefore(archive.iterator(), 1855));

    }

    public static void printAll(Iterator<Book> it) {
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book);
        }
    }

    public static int countBefore(Iterator<Book> it, int year) {
        int counter = 0;
        while (it.hasNext()) {
            Book book = it.next();
            if (book.year < year) {
                counter++;
            }
        }

        return counter;
    }
}
