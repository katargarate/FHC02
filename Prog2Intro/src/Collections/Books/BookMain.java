package Collections.Books;

import java.util.ArrayList;
import java.util.List;

public class BookMain {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";


    static void main(String[] args) {

        // bookOGMain();
        bookCaseMain();
    }

    public static void bookOGMain() {
        List<Book> books = new ArrayList<>();

        // create Book instances and add them to the books list
        Book b1 = new Book("The Midnight Library", true, 4);
        Book b2 = new Book("The Loop", false);
        Book b3 = new Book("Circe", true);
        Book b4 = new Book("The Poppy Wars", false);

        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

        // print full list
        System.out.println(ANSI_BLUE + "--- FULL ORIGINAL LIST --- \n" +  ANSI_RESET);
        printList(books);

        // add star rating to  b3
        b3.setStars(4);

        // reprint with updated book
        System.out.println(ANSI_BLUE + "--- UPDATED LIST WITH STARS ADDED TO CIRCE --- \n"+ ANSI_RESET);
        printList(books);

        // add star rating to  b2, will auto be marked as finished
        b2.setStars(5);

        // reprint with updated book
        System.out.println(ANSI_BLUE + "--- UPDATED LIST WITH STARS ADDED TO THE LOOP AND AUTO FINISHED ---\n" + ANSI_RESET);
        printList(books);
    }

    public static void printList(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void bookCaseMain() {
        BookCase bc = new BookCase();

        // create Book instances and add them to the books list
        Book b1 = new Book("The Midnight Library", true, 4);
        Book b2 = new Book("The Loop", false);
        Book b3 = new Book("Circe", true);
        Book b4 = new Book("The Poppy Wars", false);

        bc.addBook(b1);
        bc.addBook(b2);
        bc.addBook(b3);
        bc.addBook(b4);

        System.out.println(ANSI_BLUE + "--- UNREAD BOOKS ---" + ANSI_RESET);
        bc.showUnreadBooks();

        System.out.println(ANSI_BLUE + "--- READ BOOKS ---" + ANSI_RESET);
        bc.showReadBooks();
    }
}
