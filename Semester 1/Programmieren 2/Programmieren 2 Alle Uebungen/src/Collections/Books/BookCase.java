package Collections.Books;

import java.util.ArrayList;
import java.util.List;

public class BookCase {
    private List<Book> books =  new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showReadBooks() {
        for (Book book : books) {
            if (book.isFinished()) {
                System.out.println(book);
            }
        }
    }

    public void showUnreadBooks() {
        for (Book book : books) {
            if (!book.isFinished()) {
                System.out.println(book);
            }
        }
    }


    @Override
    public String toString() {
        return String.format("BookCase[books=%s]", books);
    }

}
